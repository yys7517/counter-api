package com.example.counter.controller;

import com.example.counter.service.CounterService;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {
  private final CounterService counterService;

  public CounterController(CounterService counterService) {
    this.counterService = counterService;
  }

  @GetMapping("/count")
  public Map<String, Object> getCount() throws Exception {
    String hostname = InetAddress.getLocalHost().getHostName();
    Map<String, Object> response = new HashMap<>();
    response.put("count", counterService.getCount());
    response.put("server", hostname);

    return response;
  }

  @GetMapping("/info")
  public Map<String, String> getInfo() throws Exception {
    String hostname = InetAddress.getLocalHost().getHostName();
    String ip = InetAddress.getLocalHost().getHostAddress();

    Map<String, String> response = new HashMap<>();
    response.put("ip", ip);
    response.put("server", hostname);

    return response;
  }

  @PostMapping("/count/increment")
  public Map<String, Object> increment() throws Exception {
    String hostname = InetAddress.getLocalHost().getHostName();
    Long newCount = counterService.increment();

    Map<String, Object> response = new HashMap<>();
    response.put("count", newCount);
    response.put("server", hostname);
    response.put("message", "카운트 증가!");

    return response;
  }

}
