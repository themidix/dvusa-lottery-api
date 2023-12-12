package com.midix.dvLottery.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.midix.dvLottery.dto.*;
import com.midix.dvLottery.entity.*;
import com.midix.dvLottery.exception.EmailDoNotMatchException;
import com.midix.dvLottery.mapper.*;
import com.midix.dvLottery.services.AgentService;
import com.midix.dvLottery.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.midix.dvLottery.repository.AgentRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
@Transactional
public class AgentServiceImp implements AgentService {
	private static Logger logger = LoggerFactory.getLogger(AgentServiceImp.class);
	private AgentRepository agentRepository;
	private AgentMapper agentMapper;
	private UserService userService;

	public AgentServiceImp(AgentRepository agentRepository, AgentMapper agentMapper, UserService userService) {
		this.agentRepository = agentRepository;
		this.agentMapper = agentMapper;
		this.userService = userService;
	}
	@Override
	public Agent loadAgentByID(Long agentId) {
		return agentRepository.findById(agentId).orElseThrow(()->{
			logger.error("error loading agent");
			throw new EntityNotFoundException("Agent with ID " + agentId + " not found");
		});
	}
	@Override
	public Page<AgentDTO> loadAgentByName(String name, int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Agent> agentPage = agentRepository.findAgentByName(name, pageRequest);
		logger.info("Successfully load agents");
		return new PageImpl<>(agentPage.getContent().stream().map(agent -> agentMapper.toAgentDTO(agent)).collect(Collectors.toList()), pageRequest, agentPage.getTotalElements());
	}

	@Override
	public AgentDTO loadAgentByEmail(String email) {
		return agentMapper.toAgentDTO(agentRepository.findAgentByEmail(email));
	}

	@Override
	public AgentDTO createAgent(AgentDTO agentDTO) throws EmailDoNotMatchException {
		checkIfEmailMatch(agentDTO);
		String email = agentDTO.getUserDTO().getEmail();
		User user = userService.createUser(email, agentDTO.getUserDTO().getPassword());
		userService.assignRoleToUser(user.getEmail(), "Agent");
		Agent agent = agentMapper.toAgentEntity(agentDTO);

		DVBusinessDTO dvBusinessDTO = agentDTO.getDvBusinessDTO();
		DVBusinessMapper dvBusinessMapper = new DVBusinessMapper();
		DvBusiness savedDVBusiness = dvBusinessMapper.toDVBusiness(dvBusinessDTO);

		agent.setUser(user);
		agent.setDvBusiness(savedDVBusiness);
		Agent savedAgent = agentRepository.save(agent);
		logger.info("Agent successfully created");
		return agentMapper.toAgentDTO(savedAgent);
	}
	@Override
	public AgentDTO updateAgent(AgentDTO agentDTO) {
		Agent loadedAgent = loadAgentByID(agentDTO.getAgentId());
		Agent agent = agentMapper.toAgentEntity(agentDTO);

		agent.setUser(loadedAgent.getUser());
		agent.setAgentId(loadedAgent.getAgentId());

		DVBusinessMapper dvBusinessMapper = new DVBusinessMapper();
		DVBusinessDTO dvBusinessDTO = agentDTO.getDvBusinessDTO();
		if (dvBusinessDTO  != null) {
			DvBusiness dvBusinessEntity = dvBusinessMapper.toDVBusiness(dvBusinessDTO);
			dvBusinessEntity.setDvBusinessId(loadedAgent.getDvBusiness().getDvBusinessId());
			agent.setDvBusiness(dvBusinessEntity);
		}
		Agent updatedAgent = agentRepository.save(agent);
		logger.info("Agent successfully updated");
		return agentMapper.toAgentDTO(updatedAgent);
	}
	@Override
	public void deleteAgent(Long entrantId) {
		Agent agent = loadAgentByID(entrantId);
		if(agent == null){
			logger.error("unable to delete agent");
			throw new NullPointerException();
		}
		agentRepository.deleteById(entrantId);
		logger.info("Successfully deleted Agent");
	}
	@Override
	public List<AgentDTO> loadAllAgents() {
		return null;
	}
	private void checkIfEmailMatch(AgentDTO agentDTO) throws EmailDoNotMatchException {
		if(!agentDTO.getUserDTO().getEmail().equals(agentDTO.getAgentEmail())){
			logger.error("Unable to create Agent");
			throw new EmailDoNotMatchException("Email does not match");
		}
	}
}
