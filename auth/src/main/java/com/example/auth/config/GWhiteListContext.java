package com.example.auth.config;


import com.example.auth.entity.GWhitelist;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface GWhiteListContext {

    Map<String, GWhitelist> GW = new ConcurrentHashMap<>();

}
