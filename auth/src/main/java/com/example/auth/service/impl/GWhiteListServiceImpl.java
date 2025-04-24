package com.example.auth.service.impl;

import com.example.auth.entity.GWhitelist;
import com.example.auth.repository.GWhiteListRepository;
import com.example.auth.service.GWhiteListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GWhiteListServiceImpl implements GWhiteListService {

    @Autowired
    private GWhiteListRepository gWhiteListRepository;

    @Override
    public List<GWhitelist> getAll() {
        return gWhiteListRepository.findAll();
    }
}
