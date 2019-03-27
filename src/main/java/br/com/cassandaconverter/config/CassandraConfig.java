package br.com.cassandaconverter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
@EnableCassandraRepositories(basePackages = "br.com.cassandaconverter.repository")
public class CassandraConfig extends AbstractCassandraConfiguration {

    private static final String KEYSPACE = "spring.data.cassandra.keyspace-name";
    private static final String CONTACTPOINTS = "spring.data.cassandra.contact-points";
    private static final String PORT = "spring.data.cassandra.port";

    @Autowired
    private Environment environment;

    @Override
    protected String getKeyspaceName() {
        return environment.getProperty(KEYSPACE);
    }

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(environment.getProperty(CONTACTPOINTS));
        cluster.setPort(Integer.parseInt(environment.getProperty(PORT)));
        return cluster;
    }

    @Bean
    public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }

}
