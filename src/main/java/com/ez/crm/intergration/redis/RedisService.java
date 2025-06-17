package com.ez.crm.intergration.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ValueOperations<String, Object> valueOps;

    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.valueOps = redisTemplate.opsForValue();
    }


    public void set(String key, Object value) {
        valueOps.set(key, value);
    }


    public void setWithTTL(String key, Object value, long durationInSeconds) {
        valueOps.set(key, value, Duration.ofSeconds(durationInSeconds));
    }


    public Object get(String key) {
        return valueOps.get(key);
    }


    public void delete(String key) {
        redisTemplate.delete(key);
    }


    public boolean hasKey(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }


    public Long increment(String key) {
        return valueOps.increment(key);
    }

    public Long decrement(String key) {
        return valueOps.decrement(key);
    }
}

