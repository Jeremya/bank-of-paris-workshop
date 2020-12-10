package com.bankofparis.banky.conf;

import static com.datastax.oss.driver.api.querybuilder.SchemaBuilder.createKeyspace;

import com.bankofparis.banky.operations.OperationDao;
import com.bankofparis.banky.operations.OperationDaoMapper;
import com.bankofparis.banky.operations.OperationDaoMapperBuilder;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CassandraConfig {

    /** Logger for the class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CassandraConfig.class);

    private static String KEYSPACE_NAME = "comptes";

    @Value("${datastax.useAstra:true}")
    private boolean useAstra;

    /**
     * Create the Singleton {@link CqlSession} used everywhere to
     * access the Cassandra DB.
     */
    @Bean
    public CqlSession cqlSession() {
        DriverConfigLoader configReader;
        CqlSession cqlSession;
        if (useAstra) {
            LOGGER.info("Loading configuration to Astra");
            // the file 'application-astra.conf' contains all configuration keys
            configReader = DriverConfigLoader.fromClasspath("application-astra.conf");
            cqlSession   = CqlSession.builder().withConfigLoader(configReader).build();
        } else {
            // the file 'application-astra.local' contains all configuration keys to work locally
            configReader = DriverConfigLoader.fromClasspath("application-local.conf");
            cqlSession   = CqlSession.builder().withConfigLoader(configReader).build();
            // If we are working locally (docker) we may need to create the keyspace
            cqlSession.execute(createKeyspace(KEYSPACE_NAME).ifNotExists()
                    .withSimpleStrategy(1)
                    .withDurableWrites(true)
                    .build());
            cqlSession.execute("use " + KEYSPACE_NAME);
        }

        // Create schema upfront
        return cqlSession;
    }

    @Bean
    public OperationDao operationDao(CqlSession cqlSession) {
        // A mapper is initialized with a Session.
        OperationDaoMapper operationDaoMapper = new OperationDaoMapperBuilder(cqlSession).build();

        // From the mapper we can access the Dao instance by specifying the proper keyspace.
        OperationDao operationDao = operationDaoMapper.operationDao(cqlSession.getKeyspace().get());
        return operationDao;
    }
}
