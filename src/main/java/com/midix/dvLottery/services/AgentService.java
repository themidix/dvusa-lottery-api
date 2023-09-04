package com.midix.dvLottery.services;

import java.util.List;

import com.midix.dvLottery.entity.Agent;

public interface AgentService {
	Agent saveAgent(Agent a);
	Agent updateAgent(Agent a);
	void deleteAgent(Agent a);
	void deleteAgentById(Long id);
	Agent getAgent(Long id);
	List<Agent> getAllAgents();
}
