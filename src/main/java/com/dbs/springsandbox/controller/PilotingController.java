package com.dbs.springsandbox.controller;

import com.dbs.springsandbox.service.PilotingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class PilotingController {
    private final PilotingService pilotingService;

    @GetMapping("/pilot")
    public String handle(@RequestParam String pilotKey) {
        boolean isEnabled = pilotingService.isEnabled(pilotKey);
        return "Pilot key [" + pilotKey + "] " + (isEnabled ? "is enabled" : "is disabled");
    }

    @GetMapping("/pilot/context")
    public String handle(@RequestParam String pilotKey, @RequestParam String contextValue) {
        Map<String, String> context = Map.of(pilotKey, contextValue);
        boolean isEnabled = pilotingService.isEnabled(pilotKey, context);
        return "Pilot key [" + pilotKey + "] " + (isEnabled ? "is enabled" : "is disabled");
    }
}
