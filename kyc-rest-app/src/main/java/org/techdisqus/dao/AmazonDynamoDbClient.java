package org.techdisqus.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmazonDynamoDbClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(AmazonDynamoDbClient.class);
    private DynamoDB dynamoDB;
    private DynamoDBMapper dbMapper;
    private Table table;

    public AmazonDynamoDbClient(String tableName, String region) {


        try {
            LOGGER.info("Initializing AmazonDynamoDbClient client with tableName : {}, and region: {}", tableName, region);

            AmazonDynamoDB client = new AmazonDynamoDBClient();

            dynamoDB = new DynamoDB(client);

            DynamoDBMapperConfig dbMapperConfig = new DynamoDBMapperConfig.Builder()
                    .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(tableName))
                    .build();

            dbMapper = new DynamoDBMapper(client, dbMapperConfig);

            table = dynamoDB.getTable(tableName);
            ListTablesRequest request = new ListTablesRequest();
            ListTablesResult response = client.listTables(request);
            if (response.getTableNames().isEmpty())
                LOGGER.error("No table found");

            LOGGER.info("AmazonDynamoDbClient initialized successfully with tableName : {}, and region: {}", tableName, region);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }

    /***
     * Provides an instance of the DynamoDB client for interacting with DynamoDB tables.
     * This DynamoDB client allows for creating, accessing, and performing various operations on
     * DynamoDB tables such as querying, updating, and deleting items.
     * The instance is configured with the appropriate AWS credentials and region settings.
     *
     * @return DynamoDB
     */
    public DynamoDB getDynamoDB() {

        return dynamoDB;

    }

    /**
     * Method that returns a `Table` object representing the DynamoDB table, which can be used
     * for querying, inserting, updating, and deleting items.
     *
     * @return Table
     */
    public Table getTable() {

        return table;

    }

    /***
     * Provides a DynamoDBMapper instance for interacting with DynamoDB.
     * This DynamoDBMapper enables object persistence and retrieval in DynamoDB,
     *  allowing you to save, load, and query database items using annotated domain classes.
     *
     * @return DynamoDBMapper
     */
    public DynamoDBMapper getDbMapper() {

        return dbMapper;
    }

}
