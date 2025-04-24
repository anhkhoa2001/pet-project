package com.example.auth.service;

import com.example.auth.entity.GWhitelist;
import org.example.core.request.ABaseRequest;
import org.example.core.service.IBaseService;

import java.util.List;

public interface GWhiteListService {
    
    List<GWhitelist> getAll();
    
}
