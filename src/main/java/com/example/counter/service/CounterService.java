package com.example.counter.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
  private final StringRedisTemplate redisTemplate;
  private static final String COUNTER_KEY = "visit:count";

  public CounterService(StringRedisTemplate redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public Long increment() {
    return redisTemplate.opsForValue().increment(COUNTER_KEY);
  }

  public Long getCount() {
    String count = redisTemplate.opsForValue().get(COUNTER_KEY);
    return count == null ? 0L : Long.parseLong(count);
  }
}
