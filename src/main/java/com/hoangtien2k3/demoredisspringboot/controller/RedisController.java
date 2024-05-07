package com.hoangtien2k3.demoredisspringboot.controller;

import com.hoangtien2k3.demoredisspringboot.entity.Product;
import com.hoangtien2k3.demoredisspringboot.service.BaseRedisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisController {

    private final BaseRedisService redisService;

    public RedisController(BaseRedisService redisService) {
        this.redisService = redisService;
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return redisService.save(product);
    }

    @GetMapping
    public List<Object> getAllProducts() {
        return redisService.findAll();
    }

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable int id) {
        return redisService.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id) {
        return redisService.deleteProduct(id);
    }

}
