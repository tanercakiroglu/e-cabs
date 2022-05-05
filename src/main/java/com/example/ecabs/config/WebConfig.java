package com.example.ecabs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.Locale;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        final var resolver = new AcceptHeaderLocaleResolver();
        final var turkishLocale = new Locale("tr","TR");
        resolver.setSupportedLocales(Arrays.asList(turkishLocale, Locale.US));
        resolver.setDefaultLocale(turkishLocale);
        return resolver;
    }

}
