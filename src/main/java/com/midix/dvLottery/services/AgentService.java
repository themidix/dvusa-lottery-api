package com.midix.dvLottery.services;

import java.util.List;

import com.midix.dvLottery.dto.AgentDTO;
import com.midix.dvLottery.dto.EntrantDTO;
import com.midix.dvLottery.entity.Agent;
import com.midix.dvLottery.entity.Entrant;
import com.midix.dvLottery.exception.EmailDoNotMatchException;
import org.springframework.data.domain.Page;

public interface AgentService {
	Agent loadAgentByID(Long agentId);
	Page<AgentDTO> loadAgentByName(String name, int page, int size);
	AgentDTO loadAgentByEmail(String email);
	AgentDTO createAgent(AgentDTO agentDTO) throws EmailDoNotMatchException;
	AgentDTO updateAgent(AgentDTO agentDTO);
	void deleteAgent(Long entrantId);
	List<AgentDTO> loadAllAgents();
}
