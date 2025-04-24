package com.example.auth.config;

import com.example.auth.entity.GWhitelist;
import com.example.auth.service.GWhiteListService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.core.util.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitialSystem {

    @Autowired
    private GWhiteListService gWhiteListService;

    @PostConstruct
    public void initWhiteList() {
        // Initialize the system here
        System.out.println("Whitelist initialized ...");
        List<GWhitelist> whiteLists = gWhiteListService.getAll();

        if(ValidateUtils.isNotNull(whiteLists)) {
            whiteLists.forEach(whiteList -> {
                GWhiteListContext.GW.put(whiteList.getUrl(), whiteList);
            });
        }
    }

}
