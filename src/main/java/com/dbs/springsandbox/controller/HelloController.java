package com.dbs.springsandbox.controller;

import com.dbs.springsandbox.service.SlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;

@RestController
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class HelloController {
    private final SlowService service;

    @GetMapping("/hello")
    public String handle(@RequestParam(value = "name", required = false) String name) {
        return "Hello " +  service.waitForMe((isNoneBlank(name) ? name : "WebFlux"));
    }

    @PutMapping("/reset")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearCache() {
        service.resetDefaultCache();
    }
}
