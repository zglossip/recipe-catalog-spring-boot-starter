package com.zglossip.recipecatalog.client.autoconfigure;

import com.zglossip.recipecatalog.client.config.RecipeCatalogProperties;
import com.zglossip.recipecatalog.client.services.RecipeCatalogService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(RecipeCatalogProperties.class)
public class RecipeCatalogAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    RecipeCatalogService recipeCatalogService(RecipeCatalogProperties properties) {
        return new RecipeCatalogService(properties.getBaseUrl());
    }
}