package com.midix.dvLottery.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midix.dvLottery.models.Agent;
import com.midix.dvLottery.repository.AgentRepository;

@Service
public class AgentServiceImp implements AgentService {
	
	@Autowired
	private AgentRepository agentRepository;

	@Override
	public Agent saveAgent(Agent a) {
		return agentRepository.save(a);
	}

	@Override
	public Agent updateAgent(Agent a) {
		agentRepository.findById(a.getId()).map(
				existing -> {
					existing.setNom(a.getNom());
					existing.setDateEmb(a.getDateEmb());
					existing.setEmail(a.getEmail());
					existing.setFonction(a.getFonction());
					existing.setNbrCustomer(a.getNbrCustomer());
					existing.setPassword(a.getPassword());
					existing.setSexe(a.getSexe());
					existing.setTelephone(a.getTelephone());
					existing.setVille(a.getVille());
					return agentRepository.save(existing);
				}
		).orElseThrow(null);
		return a;
	}

	@Override
	public void deleteAgent(Agent a) {
		agentRepository.delete(a);
	}

	@Override
	public void deleteAgentById(Long id) {
		agentRepository.deleteById(id);
	}

	@Override
	public Agent getAgent(Long id) {
		return agentRepository.findById(id).get();
	}

	@Override
	public List<Agent> getAllAgents() {
		return agentRepository.findAll();
	}
}
