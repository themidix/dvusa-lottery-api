package com.midix.dvLottery.mapper;

import com.midix.dvLottery.dto.AgentDTO;
import com.midix.dvLottery.entity.Agent;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AgentMapper {

    public AgentDTO toAgentDTO(Agent agent){
        AgentDTO agentDTO = new AgentDTO();
        BeanUtils.copyProperties(agent,agentDTO);
        return agentDTO;
    }

    public Agent toAgentEntity(AgentDTO agentDTO){
        Agent agent = new Agent();
        BeanUtils.copyProperties(agentDTO,agent);
        return agent;
    }
}
