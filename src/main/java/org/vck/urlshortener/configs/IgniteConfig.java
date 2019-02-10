package org.vck.urlshortener.configs;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author viswanath.ck
 */
@Configuration
@EnableIgniteRepositories
public class IgniteConfig {

    @Bean
    public Ignite igniteInstance() {
        IgniteConfiguration config = new IgniteConfiguration();

        CacheConfiguration cache = new CacheConfiguration("urlCache");
        cache.setIndexedTypes(Integer.class, String.class);

        config.setCacheConfiguration(cache);
        return Ignition.start(config);
    }
}
