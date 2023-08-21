package com.example.shomsy.security.jwt;

import com.example.shomsy.security.jwt.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean filter= new FilterRegistrationBean();
        filter.setFilter(new JwtFilter());

        filter.addUrlPatterns("/User/CountUsers");
        /*
        filter.addUrlPatterns("/PostPerson");
        filter.addUrlPatterns("/UpdatePerson");
        filter.addUrlPatterns("/DeletePerson");
        filter.addUrlPatterns("/DeleteAllPersons");
        filter.addUrlPatterns("/CountPersons");
        filter.addUrlPatterns("/GetAllPersons");
        filter.addUrlPatterns("/GetOnePerson");
        filter.addUrlPatterns("/FindPersonsByFirstName");
        filter.addUrlPatterns("/FindPersonsByDesiredAge");
        filter.addUrlPatterns("/FindPersonsByYoungerThenDesiredAge");
        filter.addUrlPatterns("/FindPersonsByOlderThenDesiredAge");
        filter.addUrlPatterns("/SortAscPersonsByAge");
        filter.addUrlPatterns("/SortDescPersonsByAge");

        filter.addUrlPatterns("/PostStore");
        filter.addUrlPatterns("/UpdateStore");
        filter.addUrlPatterns("/DeleteStore");
        filter.addUrlPatterns("/DeleteAllStores");
        filter.addUrlPatterns("/CountStores");
        filter.addUrlPatterns("/GetAllStores");
        filter.addUrlPatterns("/GetOneStore");

        filter.addUrlPatterns("/PostProduct");
        filter.addUrlPatterns("/UpdateProduct");
        filter.addUrlPatterns("/DeleteProduct");
        filter.addUrlPatterns("/DeleteAllProducts");
        filter.addUrlPatterns("/CountProducts");
        filter.addUrlPatterns("/GetAllProducts");
        filter.addUrlPatterns("/GetOneProduct");

        */
        return filter;
    }
}
