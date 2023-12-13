package com.midix.dvLottery.restController;

import com.midix.dvLottery.dto.AgentDTO;
import com.midix.dvLottery.entity.User;
import com.midix.dvLottery.exception.EmailDoNotMatchException;
import com.midix.dvLottery.services.AgentService;
import com.midix.dvLottery.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agents")
@CrossOrigin("*")
public class agentController {
    private AgentService agentService;
    private UserService userService;
    public agentController(AgentService agentService, UserService userService) {
        this.agentService = agentService;
        this.userService = userService;
    }
    @PostMapping
    @PreAuthorize("hasAuthority('Admin')")
    public AgentDTO createAgent(@RequestBody AgentDTO agentDTO) throws EmailDoNotMatchException {
        User user = userService.loadUserByEmail(agentDTO.getUserDTO().getEmail());
        if(user != null)
            throw new RuntimeException("Email already exist");
        return agentService.createAgent(agentDTO);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('Admin')")
    public Page<AgentDTO> searchAgents(@RequestParam(name = "keyword", defaultValue = "") String keyword,
                                         @RequestParam(name = "page", defaultValue = "0") int page,
                                         @RequestParam(name = "size", defaultValue = "5") int size) {
        return agentService.loadAgentByName(keyword, page, size);
    }
    @DeleteMapping("/{agentId}")
    @PreAuthorize("hasAuthority('Admin')")
    public void removeAgent(@PathVariable Long agentId) {
        agentService.deleteAgent(agentId);
    }
    @PutMapping("/{agentId}")
    @PreAuthorize("hasAuthority('Admin')")
    public AgentDTO updateAgent(@RequestBody AgentDTO agentDTO, @PathVariable Long agentId) {
        agentDTO.setAgentId(agentId);
        return agentService.updateAgent(agentDTO);
    }
    @GetMapping("/findByEmail")
    @PreAuthorize("hasAuthority('Agent')")
    public AgentDTO loadAgentByEmail(@RequestParam(name = "email", defaultValue = "") String email) {
        return agentService.loadAgentByEmail(email);
    }
}