package com.example.userservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;

@EnableReactiveCassandraRepositories
public class CassandraConfig extends AbstractReactiveCassandraConfiguration {
    @Value("${spring.cassandra.contact_point}")
    private static final String CONTACT_POINT = "";
    @Value("${spring.cassandra.port}")
    private static final int PORT = 9042;
    @Value("${spring.cassandra.keyspace}")

    private static final String KEYSPACE = "";
    @Value("${spring.cassandra.username}")
    private static final String USERNAME = "";
    @Value("${spring.cassandra.password}")
    private static final String PASSWORD = "";

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE;
    }

    @Bean
    public CqlSessionFactoryBean cluster() {
        CqlSessionFactoryBean cluster = new CqlSessionFactoryBean();
        cluster.setContactPoints(CONTACT_POINT);
        cluster.setPort(PORT);
        cluster.setUsername(USERNAME);
        cluster.setPassword(PASSWORD);
        return cluster;
    }

}
