/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

/**
 * <p>
 * Represents the properties of a table.
 * </p>
 */
public class TableDescription implements Serializable {

    /**
     * An array of <i>AttributeDefinition</i> objects. Each of these objects
     * describes one attribute in the table and index key schema. <p>Each
     * <i>AttributeDefinition</i> object in this array is composed of: <ul>
     * <li> <p><i>AttributeName</i> - The name of the attribute. </li> <li>
     * <p><i>AttributeType</i> - The data type for the attribute. </li> </ul>
     */
    private com.amazonaws.internal.ListWithAutoConstructFlag<AttributeDefinition> attributeDefinitions;

    /**
     * The name of the table.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>3 - 255<br/>
     * <b>Pattern: </b>[a-zA-Z0-9_.-]+<br/>
     */
    private String tableName;

    /**
     * The primary key structure for the table. Each <i>KeySchemaElement</i>
     * consists of: <ul> <li> <p><i>AttributeName</i> - The name of the
     * attribute. </li> <li> <p><i>KeyType</i> - The key type for the
     * attribute. Can be either <code>HASH</code> or <code>RANGE</code>.
     * </li> </ul> <p>For more information about primary keys, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey">Primary
     * Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 2<br/>
     */
    private com.amazonaws.internal.ListWithAutoConstructFlag<KeySchemaElement> keySchema;

    /**
     * The current state of the table: <ul> <li> <p><i>CREATING</i> - The
     * table is being created. </li> <li> <p><i>UPDATING</i> - The table is
     * being updated. </li> <li> <p><i>DELETING</i> - The table is being
     * deleted. </li> <li> <p><i>ACTIVE</i> - The table is ready for use.
     * </li> </ul>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>CREATING, UPDATING, DELETING, ACTIVE
     */
    private String tableStatus;

    /**
     * The date and time when the table was created, in <a
     * href="http://www.epochconverter.com/">UNIX epoch time</a> format.
     */
    private java.util.Date creationDateTime;

    /**
     * The provisioned throughput settings for the table, consisting of read
     * and write capacity units, along with data about increases and
     * decreases.
     */
    private ProvisionedThroughputDescription provisionedThroughput;

    /**
     * The total size of the specified table, in bytes. DynamoDB updates this
     * value approximately every six hours. Recent changes might not be
     * reflected in this value.
     */
    private Long tableSizeBytes;

    /**
     * The number of items in the specified table. DynamoDB updates this
     * value approximately every six hours. Recent changes might not be
     * reflected in this value.
     */
    private Long itemCount;

    /**
     * The Amazon Resource Name (ARN) that uniquely identifies the table.
     */
    private String tableArn;

    /**
     * Represents one or more local secondary indexes on the table. Each
     * index is scoped to a given hash key value. Tables with one or more
     * local secondary indexes are subject to an item collection size limit,
     * where the amount of data within a given item collection cannot exceed
     * 10 GB. Each element is composed of: <ul> <li> <p><i>IndexName</i> -
     * The name of the local secondary index. </li> <li> <p><i>KeySchema</i>
     * - Specifies the complete index key schema. The attribute names in the
     * key schema must be between 1 and 255 characters (inclusive). The key
     * schema must begin with the same hash key attribute as the table. </li>
     * <li> <p><i>Projection</i> - Specifies attributes that are copied
     * (projected) from the table into the index. These are in addition to
     * the primary key attributes and index key attributes, which are
     * automatically projected. Each attribute specification is composed of:
     * <ul> <li> <p><i>ProjectionType</i> - One of the following: <ul> <li>
     * <p><code>KEYS_ONLY</code> - Only the index and primary keys are
     * projected into the index. </li> <li> <p><code>INCLUDE</code> - Only
     * the specified table attributes are projected into the index. The list
     * of projected attributes are in <i>NonKeyAttributes</i>. </li> <li>
     * <p><code>ALL</code> - All of the table attributes are projected into
     * the index. </li> </ul> </li> <li> <p><i>NonKeyAttributes</i> - A list
     * of one or more non-key attribute names that are projected into the
     * secondary index. The total count of attributes provided in
     * <i>NonKeyAttributes</i>, summed across all of the secondary indexes,
     * must not exceed 20. If you project the same attribute into two
     * different indexes, this counts as two distinct attributes when
     * determining the total. </li> </ul> </li> <li> <p><i>IndexSizeBytes</i>
     * - Represents the total size of the index, in bytes. DynamoDB updates
     * this value approximately every six hours. Recent changes might not be
     * reflected in this value. </li> <li> <p><i>ItemCount</i> - Represents
     * the number of items in the index. DynamoDB updates this value
     * approximately every six hours. Recent changes might not be reflected
     * in this value. </li> </ul> <p>If the table is in the
     * <code>DELETING</code> state, no information about indexes will be
     * returned.
     */
    private com.amazonaws.internal.ListWithAutoConstructFlag<LocalSecondaryIndexDescription> localSecondaryIndexes;

    /**
     * The global secondary indexes, if any, on the table. Each index is
     * scoped to a given hash key value. Each element is composed of: <ul>
     * <li> <p><i>Backfilling</i> - If true, then the index is currently in
     * the backfilling phase. Backfilling occurs only when a new global
     * secondary index is added to the table; it is the process by which
     * DynamoDB populates the new index with data from the table. (This
     * attribute does not appear for indexes that were created during a
     * <i>CreateTable</i> operation.) </li> <li> <p><i>IndexName</i> - The
     * name of the global secondary index. </li> <li>
     * <p><i>IndexSizeBytes</i> - The total size of the global secondary
     * index, in bytes. DynamoDB updates this value approximately every six
     * hours. Recent changes might not be reflected in this value. </li> <li>
     * <p><i>IndexStatus</i> - The current status of the global secondary
     * index: <ul> <li> <p><i>CREATING</i> - The index is being created.
     * </li> <li> <p><i>UPDATING</i> - The index is being updated. </li> <li>
     * <p><i>DELETING</i> - The index is being deleted. </li> <li>
     * <p><i>ACTIVE</i> - The index is ready for use. </li> </ul> </li> <li>
     * <p><i>ItemCount</i> - The number of items in the global secondary
     * index. DynamoDB updates this value approximately every six hours.
     * Recent changes might not be reflected in this value. </li> <li>
     * <p><i>KeySchema</i> - Specifies the complete index key schema. The
     * attribute names in the key schema must be between 1 and 255 characters
     * (inclusive). The key schema must begin with the same hash key
     * attribute as the table. </li> <li> <p><i>Projection</i> - Specifies
     * attributes that are copied (projected) from the table into the index.
     * These are in addition to the primary key attributes and index key
     * attributes, which are automatically projected. Each attribute
     * specification is composed of: <ul> <li> <p><i>ProjectionType</i> - One
     * of the following: <ul> <li> <p><code>KEYS_ONLY</code> - Only the index
     * and primary keys are projected into the index. </li> <li>
     * <p><code>INCLUDE</code> - Only the specified table attributes are
     * projected into the index. The list of projected attributes are in
     * <i>NonKeyAttributes</i>. </li> <li> <p><code>ALL</code> - All of the
     * table attributes are projected into the index. </li> </ul> </li> <li>
     * <p><i>NonKeyAttributes</i> - A list of one or more non-key attribute
     * names that are projected into the secondary index. The total count of
     * attributes provided in <i>NonKeyAttributes</i>, summed across all of
     * the secondary indexes, must not exceed 20. If you project the same
     * attribute into two different indexes, this counts as two distinct
     * attributes when determining the total. </li> </ul> </li> <li>
     * <p><i>ProvisionedThroughput</i> - The provisioned throughput settings
     * for the global secondary index, consisting of read and write capacity
     * units, along with data about increases and decreases. </li> </ul>
     * <p>If the table is in the <code>DELETING</code> state, no information
     * about indexes will be returned.
     */
    private com.amazonaws.internal.ListWithAutoConstructFlag<GlobalSecondaryIndexDescription> globalSecondaryIndexes;

    /**
     * The current DynamoDB Streams configuration for the table.
     */
    private StreamSpecification streamSpecification;

    /**
     * A timestamp, in ISO 8601 format, for this stream. <p>Note that
     * <i>LatestStreamLabel</i> is not a unique identifier for the stream,
     * because it is possible that a stream from another table might have the
     * same timestamp. However, the combination of the following three
     * elements is guaranteed to be unique: <ul> <li><p>the AWS customer
     * ID.</li> <li><p>the table name.</li> <li><p>the
     * <i>StreamLabel</i>.</li> </ul>
     */
    private String latestStreamLabel;

    /**
     * The Amazon Resource Name (ARN) that uniquely identifies the latest
     * stream for this table.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>37 - 1024<br/>
     */
    private String latestStreamArn;

    /**
     * Default constructor for a new TableDescription object.  Callers should use the
     * setter or fluent setter (with...) methods to initialize this object after creating it.
     */
    public TableDescription() {}
    
    /**
     * An array of <i>AttributeDefinition</i> objects. Each of these objects
     * describes one attribute in the table and index key schema. <p>Each
     * <i>AttributeDefinition</i> object in this array is composed of: <ul>
     * <li> <p><i>AttributeName</i> - The name of the attribute. </li> <li>
     * <p><i>AttributeType</i> - The data type for the attribute. </li> </ul>
     *
     * @return An array of <i>AttributeDefinition</i> objects. Each of these objects
     *         describes one attribute in the table and index key schema. <p>Each
     *         <i>AttributeDefinition</i> object in this array is composed of: <ul>
     *         <li> <p><i>AttributeName</i> - The name of the attribute. </li> <li>
     *         <p><i>AttributeType</i> - The data type for the attribute. </li> </ul>
     */
    public java.util.List<AttributeDefinition> getAttributeDefinitions() {
        return attributeDefinitions;
    }
    
    /**
     * An array of <i>AttributeDefinition</i> objects. Each of these objects
     * describes one attribute in the table and index key schema. <p>Each
     * <i>AttributeDefinition</i> object in this array is composed of: <ul>
     * <li> <p><i>AttributeName</i> - The name of the attribute. </li> <li>
     * <p><i>AttributeType</i> - The data type for the attribute. </li> </ul>
     *
     * @param attributeDefinitions An array of <i>AttributeDefinition</i> objects. Each of these objects
     *         describes one attribute in the table and index key schema. <p>Each
     *         <i>AttributeDefinition</i> object in this array is composed of: <ul>
     *         <li> <p><i>AttributeName</i> - The name of the attribute. </li> <li>
     *         <p><i>AttributeType</i> - The data type for the attribute. </li> </ul>
     */
    public void setAttributeDefinitions(java.util.Collection<AttributeDefinition> attributeDefinitions) {
        if (attributeDefinitions == null) {
            this.attributeDefinitions = null;
            return;
        }
        com.amazonaws.internal.ListWithAutoConstructFlag<AttributeDefinition> attributeDefinitionsCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<AttributeDefinition>(attributeDefinitions.size());
        attributeDefinitionsCopy.addAll(attributeDefinitions);
        this.attributeDefinitions = attributeDefinitionsCopy;
    }
    
    /**
     * An array of <i>AttributeDefinition</i> objects. Each of these objects
     * describes one attribute in the table and index key schema. <p>Each
     * <i>AttributeDefinition</i> object in this array is composed of: <ul>
     * <li> <p><i>AttributeName</i> - The name of the attribute. </li> <li>
     * <p><i>AttributeType</i> - The data type for the attribute. </li> </ul>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param attributeDefinitions An array of <i>AttributeDefinition</i> objects. Each of these objects
     *         describes one attribute in the table and index key schema. <p>Each
     *         <i>AttributeDefinition</i> object in this array is composed of: <ul>
     *         <li> <p><i>AttributeName</i> - The name of the attribute. </li> <li>
     *         <p><i>AttributeType</i> - The data type for the attribute. </li> </ul>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withAttributeDefinitions(AttributeDefinition... attributeDefinitions) {
        if (getAttributeDefinitions() == null) setAttributeDefinitions(new java.util.ArrayList<AttributeDefinition>(attributeDefinitions.length));
        for (AttributeDefinition value : attributeDefinitions) {
            getAttributeDefinitions().add(value);
        }
        return this;
    }
    
    /**
     * An array of <i>AttributeDefinition</i> objects. Each of these objects
     * describes one attribute in the table and index key schema. <p>Each
     * <i>AttributeDefinition</i> object in this array is composed of: <ul>
     * <li> <p><i>AttributeName</i> - The name of the attribute. </li> <li>
     * <p><i>AttributeType</i> - The data type for the attribute. </li> </ul>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param attributeDefinitions An array of <i>AttributeDefinition</i> objects. Each of these objects
     *         describes one attribute in the table and index key schema. <p>Each
     *         <i>AttributeDefinition</i> object in this array is composed of: <ul>
     *         <li> <p><i>AttributeName</i> - The name of the attribute. </li> <li>
     *         <p><i>AttributeType</i> - The data type for the attribute. </li> </ul>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withAttributeDefinitions(java.util.Collection<AttributeDefinition> attributeDefinitions) {
        if (attributeDefinitions == null) {
            this.attributeDefinitions = null;
        } else {
            com.amazonaws.internal.ListWithAutoConstructFlag<AttributeDefinition> attributeDefinitionsCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<AttributeDefinition>(attributeDefinitions.size());
            attributeDefinitionsCopy.addAll(attributeDefinitions);
            this.attributeDefinitions = attributeDefinitionsCopy;
        }

        return this;
    }

    /**
     * The name of the table.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>3 - 255<br/>
     * <b>Pattern: </b>[a-zA-Z0-9_.-]+<br/>
     *
     * @return The name of the table.
     */
    public String getTableName() {
        return tableName;
    }
    
    /**
     * The name of the table.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>3 - 255<br/>
     * <b>Pattern: </b>[a-zA-Z0-9_.-]+<br/>
     *
     * @param tableName The name of the table.
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
    /**
     * The name of the table.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>3 - 255<br/>
     * <b>Pattern: </b>[a-zA-Z0-9_.-]+<br/>
     *
     * @param tableName The name of the table.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    /**
     * The primary key structure for the table. Each <i>KeySchemaElement</i>
     * consists of: <ul> <li> <p><i>AttributeName</i> - The name of the
     * attribute. </li> <li> <p><i>KeyType</i> - The key type for the
     * attribute. Can be either <code>HASH</code> or <code>RANGE</code>.
     * </li> </ul> <p>For more information about primary keys, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey">Primary
     * Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 2<br/>
     *
     * @return The primary key structure for the table. Each <i>KeySchemaElement</i>
     *         consists of: <ul> <li> <p><i>AttributeName</i> - The name of the
     *         attribute. </li> <li> <p><i>KeyType</i> - The key type for the
     *         attribute. Can be either <code>HASH</code> or <code>RANGE</code>.
     *         </li> </ul> <p>For more information about primary keys, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey">Primary
     *         Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    public java.util.List<KeySchemaElement> getKeySchema() {
        return keySchema;
    }
    
    /**
     * The primary key structure for the table. Each <i>KeySchemaElement</i>
     * consists of: <ul> <li> <p><i>AttributeName</i> - The name of the
     * attribute. </li> <li> <p><i>KeyType</i> - The key type for the
     * attribute. Can be either <code>HASH</code> or <code>RANGE</code>.
     * </li> </ul> <p>For more information about primary keys, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey">Primary
     * Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 2<br/>
     *
     * @param keySchema The primary key structure for the table. Each <i>KeySchemaElement</i>
     *         consists of: <ul> <li> <p><i>AttributeName</i> - The name of the
     *         attribute. </li> <li> <p><i>KeyType</i> - The key type for the
     *         attribute. Can be either <code>HASH</code> or <code>RANGE</code>.
     *         </li> </ul> <p>For more information about primary keys, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey">Primary
     *         Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     */
    public void setKeySchema(java.util.Collection<KeySchemaElement> keySchema) {
        if (keySchema == null) {
            this.keySchema = null;
            return;
        }
        com.amazonaws.internal.ListWithAutoConstructFlag<KeySchemaElement> keySchemaCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<KeySchemaElement>(keySchema.size());
        keySchemaCopy.addAll(keySchema);
        this.keySchema = keySchemaCopy;
    }
    
    /**
     * The primary key structure for the table. Each <i>KeySchemaElement</i>
     * consists of: <ul> <li> <p><i>AttributeName</i> - The name of the
     * attribute. </li> <li> <p><i>KeyType</i> - The key type for the
     * attribute. Can be either <code>HASH</code> or <code>RANGE</code>.
     * </li> </ul> <p>For more information about primary keys, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey">Primary
     * Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 2<br/>
     *
     * @param keySchema The primary key structure for the table. Each <i>KeySchemaElement</i>
     *         consists of: <ul> <li> <p><i>AttributeName</i> - The name of the
     *         attribute. </li> <li> <p><i>KeyType</i> - The key type for the
     *         attribute. Can be either <code>HASH</code> or <code>RANGE</code>.
     *         </li> </ul> <p>For more information about primary keys, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey">Primary
     *         Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withKeySchema(KeySchemaElement... keySchema) {
        if (getKeySchema() == null) setKeySchema(new java.util.ArrayList<KeySchemaElement>(keySchema.length));
        for (KeySchemaElement value : keySchema) {
            getKeySchema().add(value);
        }
        return this;
    }
    
    /**
     * The primary key structure for the table. Each <i>KeySchemaElement</i>
     * consists of: <ul> <li> <p><i>AttributeName</i> - The name of the
     * attribute. </li> <li> <p><i>KeyType</i> - The key type for the
     * attribute. Can be either <code>HASH</code> or <code>RANGE</code>.
     * </li> </ul> <p>For more information about primary keys, see <a
     * href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey">Primary
     * Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 2<br/>
     *
     * @param keySchema The primary key structure for the table. Each <i>KeySchemaElement</i>
     *         consists of: <ul> <li> <p><i>AttributeName</i> - The name of the
     *         attribute. </li> <li> <p><i>KeyType</i> - The key type for the
     *         attribute. Can be either <code>HASH</code> or <code>RANGE</code>.
     *         </li> </ul> <p>For more information about primary keys, see <a
     *         href="http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DataModel.html#DataModelPrimaryKey">Primary
     *         Key</a> in the <i>Amazon DynamoDB Developer Guide</i>.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withKeySchema(java.util.Collection<KeySchemaElement> keySchema) {
        if (keySchema == null) {
            this.keySchema = null;
        } else {
            com.amazonaws.internal.ListWithAutoConstructFlag<KeySchemaElement> keySchemaCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<KeySchemaElement>(keySchema.size());
            keySchemaCopy.addAll(keySchema);
            this.keySchema = keySchemaCopy;
        }

        return this;
    }

    /**
     * The current state of the table: <ul> <li> <p><i>CREATING</i> - The
     * table is being created. </li> <li> <p><i>UPDATING</i> - The table is
     * being updated. </li> <li> <p><i>DELETING</i> - The table is being
     * deleted. </li> <li> <p><i>ACTIVE</i> - The table is ready for use.
     * </li> </ul>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>CREATING, UPDATING, DELETING, ACTIVE
     *
     * @return The current state of the table: <ul> <li> <p><i>CREATING</i> - The
     *         table is being created. </li> <li> <p><i>UPDATING</i> - The table is
     *         being updated. </li> <li> <p><i>DELETING</i> - The table is being
     *         deleted. </li> <li> <p><i>ACTIVE</i> - The table is ready for use.
     *         </li> </ul>
     *
     * @see TableStatus
     */
    public String getTableStatus() {
        return tableStatus;
    }
    
    /**
     * The current state of the table: <ul> <li> <p><i>CREATING</i> - The
     * table is being created. </li> <li> <p><i>UPDATING</i> - The table is
     * being updated. </li> <li> <p><i>DELETING</i> - The table is being
     * deleted. </li> <li> <p><i>ACTIVE</i> - The table is ready for use.
     * </li> </ul>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>CREATING, UPDATING, DELETING, ACTIVE
     *
     * @param tableStatus The current state of the table: <ul> <li> <p><i>CREATING</i> - The
     *         table is being created. </li> <li> <p><i>UPDATING</i> - The table is
     *         being updated. </li> <li> <p><i>DELETING</i> - The table is being
     *         deleted. </li> <li> <p><i>ACTIVE</i> - The table is ready for use.
     *         </li> </ul>
     *
     * @see TableStatus
     */
    public void setTableStatus(String tableStatus) {
        this.tableStatus = tableStatus;
    }
    
    /**
     * The current state of the table: <ul> <li> <p><i>CREATING</i> - The
     * table is being created. </li> <li> <p><i>UPDATING</i> - The table is
     * being updated. </li> <li> <p><i>DELETING</i> - The table is being
     * deleted. </li> <li> <p><i>ACTIVE</i> - The table is ready for use.
     * </li> </ul>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>CREATING, UPDATING, DELETING, ACTIVE
     *
     * @param tableStatus The current state of the table: <ul> <li> <p><i>CREATING</i> - The
     *         table is being created. </li> <li> <p><i>UPDATING</i> - The table is
     *         being updated. </li> <li> <p><i>DELETING</i> - The table is being
     *         deleted. </li> <li> <p><i>ACTIVE</i> - The table is ready for use.
     *         </li> </ul>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     *
     * @see TableStatus
     */
    public TableDescription withTableStatus(String tableStatus) {
        this.tableStatus = tableStatus;
        return this;
    }

    /**
     * The current state of the table: <ul> <li> <p><i>CREATING</i> - The
     * table is being created. </li> <li> <p><i>UPDATING</i> - The table is
     * being updated. </li> <li> <p><i>DELETING</i> - The table is being
     * deleted. </li> <li> <p><i>ACTIVE</i> - The table is ready for use.
     * </li> </ul>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>CREATING, UPDATING, DELETING, ACTIVE
     *
     * @param tableStatus The current state of the table: <ul> <li> <p><i>CREATING</i> - The
     *         table is being created. </li> <li> <p><i>UPDATING</i> - The table is
     *         being updated. </li> <li> <p><i>DELETING</i> - The table is being
     *         deleted. </li> <li> <p><i>ACTIVE</i> - The table is ready for use.
     *         </li> </ul>
     *
     * @see TableStatus
     */
    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus.toString();
    }
    
    /**
     * The current state of the table: <ul> <li> <p><i>CREATING</i> - The
     * table is being created. </li> <li> <p><i>UPDATING</i> - The table is
     * being updated. </li> <li> <p><i>DELETING</i> - The table is being
     * deleted. </li> <li> <p><i>ACTIVE</i> - The table is ready for use.
     * </li> </ul>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Allowed Values: </b>CREATING, UPDATING, DELETING, ACTIVE
     *
     * @param tableStatus The current state of the table: <ul> <li> <p><i>CREATING</i> - The
     *         table is being created. </li> <li> <p><i>UPDATING</i> - The table is
     *         being updated. </li> <li> <p><i>DELETING</i> - The table is being
     *         deleted. </li> <li> <p><i>ACTIVE</i> - The table is ready for use.
     *         </li> </ul>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     *
     * @see TableStatus
     */
    public TableDescription withTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus.toString();
        return this;
    }

    /**
     * The date and time when the table was created, in <a
     * href="http://www.epochconverter.com/">UNIX epoch time</a> format.
     *
     * @return The date and time when the table was created, in <a
     *         href="http://www.epochconverter.com/">UNIX epoch time</a> format.
     */
    public java.util.Date getCreationDateTime() {
        return creationDateTime;
    }
    
    /**
     * The date and time when the table was created, in <a
     * href="http://www.epochconverter.com/">UNIX epoch time</a> format.
     *
     * @param creationDateTime The date and time when the table was created, in <a
     *         href="http://www.epochconverter.com/">UNIX epoch time</a> format.
     */
    public void setCreationDateTime(java.util.Date creationDateTime) {
        this.creationDateTime = creationDateTime;
    }
    
    /**
     * The date and time when the table was created, in <a
     * href="http://www.epochconverter.com/">UNIX epoch time</a> format.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param creationDateTime The date and time when the table was created, in <a
     *         href="http://www.epochconverter.com/">UNIX epoch time</a> format.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withCreationDateTime(java.util.Date creationDateTime) {
        this.creationDateTime = creationDateTime;
        return this;
    }

    /**
     * The provisioned throughput settings for the table, consisting of read
     * and write capacity units, along with data about increases and
     * decreases.
     *
     * @return The provisioned throughput settings for the table, consisting of read
     *         and write capacity units, along with data about increases and
     *         decreases.
     */
    public ProvisionedThroughputDescription getProvisionedThroughput() {
        return provisionedThroughput;
    }
    
    /**
     * The provisioned throughput settings for the table, consisting of read
     * and write capacity units, along with data about increases and
     * decreases.
     *
     * @param provisionedThroughput The provisioned throughput settings for the table, consisting of read
     *         and write capacity units, along with data about increases and
     *         decreases.
     */
    public void setProvisionedThroughput(ProvisionedThroughputDescription provisionedThroughput) {
        this.provisionedThroughput = provisionedThroughput;
    }
    
    /**
     * The provisioned throughput settings for the table, consisting of read
     * and write capacity units, along with data about increases and
     * decreases.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param provisionedThroughput The provisioned throughput settings for the table, consisting of read
     *         and write capacity units, along with data about increases and
     *         decreases.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withProvisionedThroughput(ProvisionedThroughputDescription provisionedThroughput) {
        this.provisionedThroughput = provisionedThroughput;
        return this;
    }

    /**
     * The total size of the specified table, in bytes. DynamoDB updates this
     * value approximately every six hours. Recent changes might not be
     * reflected in this value.
     *
     * @return The total size of the specified table, in bytes. DynamoDB updates this
     *         value approximately every six hours. Recent changes might not be
     *         reflected in this value.
     */
    public Long getTableSizeBytes() {
        return tableSizeBytes;
    }
    
    /**
     * The total size of the specified table, in bytes. DynamoDB updates this
     * value approximately every six hours. Recent changes might not be
     * reflected in this value.
     *
     * @param tableSizeBytes The total size of the specified table, in bytes. DynamoDB updates this
     *         value approximately every six hours. Recent changes might not be
     *         reflected in this value.
     */
    public void setTableSizeBytes(Long tableSizeBytes) {
        this.tableSizeBytes = tableSizeBytes;
    }
    
    /**
     * The total size of the specified table, in bytes. DynamoDB updates this
     * value approximately every six hours. Recent changes might not be
     * reflected in this value.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param tableSizeBytes The total size of the specified table, in bytes. DynamoDB updates this
     *         value approximately every six hours. Recent changes might not be
     *         reflected in this value.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withTableSizeBytes(Long tableSizeBytes) {
        this.tableSizeBytes = tableSizeBytes;
        return this;
    }

    /**
     * The number of items in the specified table. DynamoDB updates this
     * value approximately every six hours. Recent changes might not be
     * reflected in this value.
     *
     * @return The number of items in the specified table. DynamoDB updates this
     *         value approximately every six hours. Recent changes might not be
     *         reflected in this value.
     */
    public Long getItemCount() {
        return itemCount;
    }
    
    /**
     * The number of items in the specified table. DynamoDB updates this
     * value approximately every six hours. Recent changes might not be
     * reflected in this value.
     *
     * @param itemCount The number of items in the specified table. DynamoDB updates this
     *         value approximately every six hours. Recent changes might not be
     *         reflected in this value.
     */
    public void setItemCount(Long itemCount) {
        this.itemCount = itemCount;
    }
    
    /**
     * The number of items in the specified table. DynamoDB updates this
     * value approximately every six hours. Recent changes might not be
     * reflected in this value.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param itemCount The number of items in the specified table. DynamoDB updates this
     *         value approximately every six hours. Recent changes might not be
     *         reflected in this value.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withItemCount(Long itemCount) {
        this.itemCount = itemCount;
        return this;
    }

    /**
     * The Amazon Resource Name (ARN) that uniquely identifies the table.
     *
     * @return The Amazon Resource Name (ARN) that uniquely identifies the table.
     */
    public String getTableArn() {
        return tableArn;
    }
    
    /**
     * The Amazon Resource Name (ARN) that uniquely identifies the table.
     *
     * @param tableArn The Amazon Resource Name (ARN) that uniquely identifies the table.
     */
    public void setTableArn(String tableArn) {
        this.tableArn = tableArn;
    }
    
    /**
     * The Amazon Resource Name (ARN) that uniquely identifies the table.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param tableArn The Amazon Resource Name (ARN) that uniquely identifies the table.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withTableArn(String tableArn) {
        this.tableArn = tableArn;
        return this;
    }

    /**
     * Represents one or more local secondary indexes on the table. Each
     * index is scoped to a given hash key value. Tables with one or more
     * local secondary indexes are subject to an item collection size limit,
     * where the amount of data within a given item collection cannot exceed
     * 10 GB. Each element is composed of: <ul> <li> <p><i>IndexName</i> -
     * The name of the local secondary index. </li> <li> <p><i>KeySchema</i>
     * - Specifies the complete index key schema. The attribute names in the
     * key schema must be between 1 and 255 characters (inclusive). The key
     * schema must begin with the same hash key attribute as the table. </li>
     * <li> <p><i>Projection</i> - Specifies attributes that are copied
     * (projected) from the table into the index. These are in addition to
     * the primary key attributes and index key attributes, which are
     * automatically projected. Each attribute specification is composed of:
     * <ul> <li> <p><i>ProjectionType</i> - One of the following: <ul> <li>
     * <p><code>KEYS_ONLY</code> - Only the index and primary keys are
     * projected into the index. </li> <li> <p><code>INCLUDE</code> - Only
     * the specified table attributes are projected into the index. The list
     * of projected attributes are in <i>NonKeyAttributes</i>. </li> <li>
     * <p><code>ALL</code> - All of the table attributes are projected into
     * the index. </li> </ul> </li> <li> <p><i>NonKeyAttributes</i> - A list
     * of one or more non-key attribute names that are projected into the
     * secondary index. The total count of attributes provided in
     * <i>NonKeyAttributes</i>, summed across all of the secondary indexes,
     * must not exceed 20. If you project the same attribute into two
     * different indexes, this counts as two distinct attributes when
     * determining the total. </li> </ul> </li> <li> <p><i>IndexSizeBytes</i>
     * - Represents the total size of the index, in bytes. DynamoDB updates
     * this value approximately every six hours. Recent changes might not be
     * reflected in this value. </li> <li> <p><i>ItemCount</i> - Represents
     * the number of items in the index. DynamoDB updates this value
     * approximately every six hours. Recent changes might not be reflected
     * in this value. </li> </ul> <p>If the table is in the
     * <code>DELETING</code> state, no information about indexes will be
     * returned.
     *
     * @return Represents one or more local secondary indexes on the table. Each
     *         index is scoped to a given hash key value. Tables with one or more
     *         local secondary indexes are subject to an item collection size limit,
     *         where the amount of data within a given item collection cannot exceed
     *         10 GB. Each element is composed of: <ul> <li> <p><i>IndexName</i> -
     *         The name of the local secondary index. </li> <li> <p><i>KeySchema</i>
     *         - Specifies the complete index key schema. The attribute names in the
     *         key schema must be between 1 and 255 characters (inclusive). The key
     *         schema must begin with the same hash key attribute as the table. </li>
     *         <li> <p><i>Projection</i> - Specifies attributes that are copied
     *         (projected) from the table into the index. These are in addition to
     *         the primary key attributes and index key attributes, which are
     *         automatically projected. Each attribute specification is composed of:
     *         <ul> <li> <p><i>ProjectionType</i> - One of the following: <ul> <li>
     *         <p><code>KEYS_ONLY</code> - Only the index and primary keys are
     *         projected into the index. </li> <li> <p><code>INCLUDE</code> - Only
     *         the specified table attributes are projected into the index. The list
     *         of projected attributes are in <i>NonKeyAttributes</i>. </li> <li>
     *         <p><code>ALL</code> - All of the table attributes are projected into
     *         the index. </li> </ul> </li> <li> <p><i>NonKeyAttributes</i> - A list
     *         of one or more non-key attribute names that are projected into the
     *         secondary index. The total count of attributes provided in
     *         <i>NonKeyAttributes</i>, summed across all of the secondary indexes,
     *         must not exceed 20. If you project the same attribute into two
     *         different indexes, this counts as two distinct attributes when
     *         determining the total. </li> </ul> </li> <li> <p><i>IndexSizeBytes</i>
     *         - Represents the total size of the index, in bytes. DynamoDB updates
     *         this value approximately every six hours. Recent changes might not be
     *         reflected in this value. </li> <li> <p><i>ItemCount</i> - Represents
     *         the number of items in the index. DynamoDB updates this value
     *         approximately every six hours. Recent changes might not be reflected
     *         in this value. </li> </ul> <p>If the table is in the
     *         <code>DELETING</code> state, no information about indexes will be
     *         returned.
     */
    public java.util.List<LocalSecondaryIndexDescription> getLocalSecondaryIndexes() {
        return localSecondaryIndexes;
    }
    
    /**
     * Represents one or more local secondary indexes on the table. Each
     * index is scoped to a given hash key value. Tables with one or more
     * local secondary indexes are subject to an item collection size limit,
     * where the amount of data within a given item collection cannot exceed
     * 10 GB. Each element is composed of: <ul> <li> <p><i>IndexName</i> -
     * The name of the local secondary index. </li> <li> <p><i>KeySchema</i>
     * - Specifies the complete index key schema. The attribute names in the
     * key schema must be between 1 and 255 characters (inclusive). The key
     * schema must begin with the same hash key attribute as the table. </li>
     * <li> <p><i>Projection</i> - Specifies attributes that are copied
     * (projected) from the table into the index. These are in addition to
     * the primary key attributes and index key attributes, which are
     * automatically projected. Each attribute specification is composed of:
     * <ul> <li> <p><i>ProjectionType</i> - One of the following: <ul> <li>
     * <p><code>KEYS_ONLY</code> - Only the index and primary keys are
     * projected into the index. </li> <li> <p><code>INCLUDE</code> - Only
     * the specified table attributes are projected into the index. The list
     * of projected attributes are in <i>NonKeyAttributes</i>. </li> <li>
     * <p><code>ALL</code> - All of the table attributes are projected into
     * the index. </li> </ul> </li> <li> <p><i>NonKeyAttributes</i> - A list
     * of one or more non-key attribute names that are projected into the
     * secondary index. The total count of attributes provided in
     * <i>NonKeyAttributes</i>, summed across all of the secondary indexes,
     * must not exceed 20. If you project the same attribute into two
     * different indexes, this counts as two distinct attributes when
     * determining the total. </li> </ul> </li> <li> <p><i>IndexSizeBytes</i>
     * - Represents the total size of the index, in bytes. DynamoDB updates
     * this value approximately every six hours. Recent changes might not be
     * reflected in this value. </li> <li> <p><i>ItemCount</i> - Represents
     * the number of items in the index. DynamoDB updates this value
     * approximately every six hours. Recent changes might not be reflected
     * in this value. </li> </ul> <p>If the table is in the
     * <code>DELETING</code> state, no information about indexes will be
     * returned.
     *
     * @param localSecondaryIndexes Represents one or more local secondary indexes on the table. Each
     *         index is scoped to a given hash key value. Tables with one or more
     *         local secondary indexes are subject to an item collection size limit,
     *         where the amount of data within a given item collection cannot exceed
     *         10 GB. Each element is composed of: <ul> <li> <p><i>IndexName</i> -
     *         The name of the local secondary index. </li> <li> <p><i>KeySchema</i>
     *         - Specifies the complete index key schema. The attribute names in the
     *         key schema must be between 1 and 255 characters (inclusive). The key
     *         schema must begin with the same hash key attribute as the table. </li>
     *         <li> <p><i>Projection</i> - Specifies attributes that are copied
     *         (projected) from the table into the index. These are in addition to
     *         the primary key attributes and index key attributes, which are
     *         automatically projected. Each attribute specification is composed of:
     *         <ul> <li> <p><i>ProjectionType</i> - One of the following: <ul> <li>
     *         <p><code>KEYS_ONLY</code> - Only the index and primary keys are
     *         projected into the index. </li> <li> <p><code>INCLUDE</code> - Only
     *         the specified table attributes are projected into the index. The list
     *         of projected attributes are in <i>NonKeyAttributes</i>. </li> <li>
     *         <p><code>ALL</code> - All of the table attributes are projected into
     *         the index. </li> </ul> </li> <li> <p><i>NonKeyAttributes</i> - A list
     *         of one or more non-key attribute names that are projected into the
     *         secondary index. The total count of attributes provided in
     *         <i>NonKeyAttributes</i>, summed across all of the secondary indexes,
     *         must not exceed 20. If you project the same attribute into two
     *         different indexes, this counts as two distinct attributes when
     *         determining the total. </li> </ul> </li> <li> <p><i>IndexSizeBytes</i>
     *         - Represents the total size of the index, in bytes. DynamoDB updates
     *         this value approximately every six hours. Recent changes might not be
     *         reflected in this value. </li> <li> <p><i>ItemCount</i> - Represents
     *         the number of items in the index. DynamoDB updates this value
     *         approximately every six hours. Recent changes might not be reflected
     *         in this value. </li> </ul> <p>If the table is in the
     *         <code>DELETING</code> state, no information about indexes will be
     *         returned.
     */
    public void setLocalSecondaryIndexes(java.util.Collection<LocalSecondaryIndexDescription> localSecondaryIndexes) {
        if (localSecondaryIndexes == null) {
            this.localSecondaryIndexes = null;
            return;
        }
        com.amazonaws.internal.ListWithAutoConstructFlag<LocalSecondaryIndexDescription> localSecondaryIndexesCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<LocalSecondaryIndexDescription>(localSecondaryIndexes.size());
        localSecondaryIndexesCopy.addAll(localSecondaryIndexes);
        this.localSecondaryIndexes = localSecondaryIndexesCopy;
    }
    
    /**
     * Represents one or more local secondary indexes on the table. Each
     * index is scoped to a given hash key value. Tables with one or more
     * local secondary indexes are subject to an item collection size limit,
     * where the amount of data within a given item collection cannot exceed
     * 10 GB. Each element is composed of: <ul> <li> <p><i>IndexName</i> -
     * The name of the local secondary index. </li> <li> <p><i>KeySchema</i>
     * - Specifies the complete index key schema. The attribute names in the
     * key schema must be between 1 and 255 characters (inclusive). The key
     * schema must begin with the same hash key attribute as the table. </li>
     * <li> <p><i>Projection</i> - Specifies attributes that are copied
     * (projected) from the table into the index. These are in addition to
     * the primary key attributes and index key attributes, which are
     * automatically projected. Each attribute specification is composed of:
     * <ul> <li> <p><i>ProjectionType</i> - One of the following: <ul> <li>
     * <p><code>KEYS_ONLY</code> - Only the index and primary keys are
     * projected into the index. </li> <li> <p><code>INCLUDE</code> - Only
     * the specified table attributes are projected into the index. The list
     * of projected attributes are in <i>NonKeyAttributes</i>. </li> <li>
     * <p><code>ALL</code> - All of the table attributes are projected into
     * the index. </li> </ul> </li> <li> <p><i>NonKeyAttributes</i> - A list
     * of one or more non-key attribute names that are projected into the
     * secondary index. The total count of attributes provided in
     * <i>NonKeyAttributes</i>, summed across all of the secondary indexes,
     * must not exceed 20. If you project the same attribute into two
     * different indexes, this counts as two distinct attributes when
     * determining the total. </li> </ul> </li> <li> <p><i>IndexSizeBytes</i>
     * - Represents the total size of the index, in bytes. DynamoDB updates
     * this value approximately every six hours. Recent changes might not be
     * reflected in this value. </li> <li> <p><i>ItemCount</i> - Represents
     * the number of items in the index. DynamoDB updates this value
     * approximately every six hours. Recent changes might not be reflected
     * in this value. </li> </ul> <p>If the table is in the
     * <code>DELETING</code> state, no information about indexes will be
     * returned.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param localSecondaryIndexes Represents one or more local secondary indexes on the table. Each
     *         index is scoped to a given hash key value. Tables with one or more
     *         local secondary indexes are subject to an item collection size limit,
     *         where the amount of data within a given item collection cannot exceed
     *         10 GB. Each element is composed of: <ul> <li> <p><i>IndexName</i> -
     *         The name of the local secondary index. </li> <li> <p><i>KeySchema</i>
     *         - Specifies the complete index key schema. The attribute names in the
     *         key schema must be between 1 and 255 characters (inclusive). The key
     *         schema must begin with the same hash key attribute as the table. </li>
     *         <li> <p><i>Projection</i> - Specifies attributes that are copied
     *         (projected) from the table into the index. These are in addition to
     *         the primary key attributes and index key attributes, which are
     *         automatically projected. Each attribute specification is composed of:
     *         <ul> <li> <p><i>ProjectionType</i> - One of the following: <ul> <li>
     *         <p><code>KEYS_ONLY</code> - Only the index and primary keys are
     *         projected into the index. </li> <li> <p><code>INCLUDE</code> - Only
     *         the specified table attributes are projected into the index. The list
     *         of projected attributes are in <i>NonKeyAttributes</i>. </li> <li>
     *         <p><code>ALL</code> - All of the table attributes are projected into
     *         the index. </li> </ul> </li> <li> <p><i>NonKeyAttributes</i> - A list
     *         of one or more non-key attribute names that are projected into the
     *         secondary index. The total count of attributes provided in
     *         <i>NonKeyAttributes</i>, summed across all of the secondary indexes,
     *         must not exceed 20. If you project the same attribute into two
     *         different indexes, this counts as two distinct attributes when
     *         determining the total. </li> </ul> </li> <li> <p><i>IndexSizeBytes</i>
     *         - Represents the total size of the index, in bytes. DynamoDB updates
     *         this value approximately every six hours. Recent changes might not be
     *         reflected in this value. </li> <li> <p><i>ItemCount</i> - Represents
     *         the number of items in the index. DynamoDB updates this value
     *         approximately every six hours. Recent changes might not be reflected
     *         in this value. </li> </ul> <p>If the table is in the
     *         <code>DELETING</code> state, no information about indexes will be
     *         returned.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withLocalSecondaryIndexes(LocalSecondaryIndexDescription... localSecondaryIndexes) {
        if (getLocalSecondaryIndexes() == null) setLocalSecondaryIndexes(new java.util.ArrayList<LocalSecondaryIndexDescription>(localSecondaryIndexes.length));
        for (LocalSecondaryIndexDescription value : localSecondaryIndexes) {
            getLocalSecondaryIndexes().add(value);
        }
        return this;
    }
    
    /**
     * Represents one or more local secondary indexes on the table. Each
     * index is scoped to a given hash key value. Tables with one or more
     * local secondary indexes are subject to an item collection size limit,
     * where the amount of data within a given item collection cannot exceed
     * 10 GB. Each element is composed of: <ul> <li> <p><i>IndexName</i> -
     * The name of the local secondary index. </li> <li> <p><i>KeySchema</i>
     * - Specifies the complete index key schema. The attribute names in the
     * key schema must be between 1 and 255 characters (inclusive). The key
     * schema must begin with the same hash key attribute as the table. </li>
     * <li> <p><i>Projection</i> - Specifies attributes that are copied
     * (projected) from the table into the index. These are in addition to
     * the primary key attributes and index key attributes, which are
     * automatically projected. Each attribute specification is composed of:
     * <ul> <li> <p><i>ProjectionType</i> - One of the following: <ul> <li>
     * <p><code>KEYS_ONLY</code> - Only the index and primary keys are
     * projected into the index. </li> <li> <p><code>INCLUDE</code> - Only
     * the specified table attributes are projected into the index. The list
     * of projected attributes are in <i>NonKeyAttributes</i>. </li> <li>
     * <p><code>ALL</code> - All of the table attributes are projected into
     * the index. </li> </ul> </li> <li> <p><i>NonKeyAttributes</i> - A list
     * of one or more non-key attribute names that are projected into the
     * secondary index. The total count of attributes provided in
     * <i>NonKeyAttributes</i>, summed across all of the secondary indexes,
     * must not exceed 20. If you project the same attribute into two
     * different indexes, this counts as two distinct attributes when
     * determining the total. </li> </ul> </li> <li> <p><i>IndexSizeBytes</i>
     * - Represents the total size of the index, in bytes. DynamoDB updates
     * this value approximately every six hours. Recent changes might not be
     * reflected in this value. </li> <li> <p><i>ItemCount</i> - Represents
     * the number of items in the index. DynamoDB updates this value
     * approximately every six hours. Recent changes might not be reflected
     * in this value. </li> </ul> <p>If the table is in the
     * <code>DELETING</code> state, no information about indexes will be
     * returned.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param localSecondaryIndexes Represents one or more local secondary indexes on the table. Each
     *         index is scoped to a given hash key value. Tables with one or more
     *         local secondary indexes are subject to an item collection size limit,
     *         where the amount of data within a given item collection cannot exceed
     *         10 GB. Each element is composed of: <ul> <li> <p><i>IndexName</i> -
     *         The name of the local secondary index. </li> <li> <p><i>KeySchema</i>
     *         - Specifies the complete index key schema. The attribute names in the
     *         key schema must be between 1 and 255 characters (inclusive). The key
     *         schema must begin with the same hash key attribute as the table. </li>
     *         <li> <p><i>Projection</i> - Specifies attributes that are copied
     *         (projected) from the table into the index. These are in addition to
     *         the primary key attributes and index key attributes, which are
     *         automatically projected. Each attribute specification is composed of:
     *         <ul> <li> <p><i>ProjectionType</i> - One of the following: <ul> <li>
     *         <p><code>KEYS_ONLY</code> - Only the index and primary keys are
     *         projected into the index. </li> <li> <p><code>INCLUDE</code> - Only
     *         the specified table attributes are projected into the index. The list
     *         of projected attributes are in <i>NonKeyAttributes</i>. </li> <li>
     *         <p><code>ALL</code> - All of the table attributes are projected into
     *         the index. </li> </ul> </li> <li> <p><i>NonKeyAttributes</i> - A list
     *         of one or more non-key attribute names that are projected into the
     *         secondary index. The total count of attributes provided in
     *         <i>NonKeyAttributes</i>, summed across all of the secondary indexes,
     *         must not exceed 20. If you project the same attribute into two
     *         different indexes, this counts as two distinct attributes when
     *         determining the total. </li> </ul> </li> <li> <p><i>IndexSizeBytes</i>
     *         - Represents the total size of the index, in bytes. DynamoDB updates
     *         this value approximately every six hours. Recent changes might not be
     *         reflected in this value. </li> <li> <p><i>ItemCount</i> - Represents
     *         the number of items in the index. DynamoDB updates this value
     *         approximately every six hours. Recent changes might not be reflected
     *         in this value. </li> </ul> <p>If the table is in the
     *         <code>DELETING</code> state, no information about indexes will be
     *         returned.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withLocalSecondaryIndexes(java.util.Collection<LocalSecondaryIndexDescription> localSecondaryIndexes) {
        if (localSecondaryIndexes == null) {
            this.localSecondaryIndexes = null;
        } else {
            com.amazonaws.internal.ListWithAutoConstructFlag<LocalSecondaryIndexDescription> localSecondaryIndexesCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<LocalSecondaryIndexDescription>(localSecondaryIndexes.size());
            localSecondaryIndexesCopy.addAll(localSecondaryIndexes);
            this.localSecondaryIndexes = localSecondaryIndexesCopy;
        }

        return this;
    }

    /**
     * The global secondary indexes, if any, on the table. Each index is
     * scoped to a given hash key value. Each element is composed of: <ul>
     * <li> <p><i>Backfilling</i> - If true, then the index is currently in
     * the backfilling phase. Backfilling occurs only when a new global
     * secondary index is added to the table; it is the process by which
     * DynamoDB populates the new index with data from the table. (This
     * attribute does not appear for indexes that were created during a
     * <i>CreateTable</i> operation.) </li> <li> <p><i>IndexName</i> - The
     * name of the global secondary index. </li> <li>
     * <p><i>IndexSizeBytes</i> - The total size of the global secondary
     * index, in bytes. DynamoDB updates this value approximately every six
     * hours. Recent changes might not be reflected in this value. </li> <li>
     * <p><i>IndexStatus</i> - The current status of the global secondary
     * index: <ul> <li> <p><i>CREATING</i> - The index is being created.
     * </li> <li> <p><i>UPDATING</i> - The index is being updated. </li> <li>
     * <p><i>DELETING</i> - The index is being deleted. </li> <li>
     * <p><i>ACTIVE</i> - The index is ready for use. </li> </ul> </li> <li>
     * <p><i>ItemCount</i> - The number of items in the global secondary
     * index. DynamoDB updates this value approximately every six hours.
     * Recent changes might not be reflected in this value. </li> <li>
     * <p><i>KeySchema</i> - Specifies the complete index key schema. The
     * attribute names in the key schema must be between 1 and 255 characters
     * (inclusive). The key schema must begin with the same hash key
     * attribute as the table. </li> <li> <p><i>Projection</i> - Specifies
     * attributes that are copied (projected) from the table into the index.
     * These are in addition to the primary key attributes and index key
     * attributes, which are automatically projected. Each attribute
     * specification is composed of: <ul> <li> <p><i>ProjectionType</i> - One
     * of the following: <ul> <li> <p><code>KEYS_ONLY</code> - Only the index
     * and primary keys are projected into the index. </li> <li>
     * <p><code>INCLUDE</code> - Only the specified table attributes are
     * projected into the index. The list of projected attributes are in
     * <i>NonKeyAttributes</i>. </li> <li> <p><code>ALL</code> - All of the
     * table attributes are projected into the index. </li> </ul> </li> <li>
     * <p><i>NonKeyAttributes</i> - A list of one or more non-key attribute
     * names that are projected into the secondary index. The total count of
     * attributes provided in <i>NonKeyAttributes</i>, summed across all of
     * the secondary indexes, must not exceed 20. If you project the same
     * attribute into two different indexes, this counts as two distinct
     * attributes when determining the total. </li> </ul> </li> <li>
     * <p><i>ProvisionedThroughput</i> - The provisioned throughput settings
     * for the global secondary index, consisting of read and write capacity
     * units, along with data about increases and decreases. </li> </ul>
     * <p>If the table is in the <code>DELETING</code> state, no information
     * about indexes will be returned.
     *
     * @return The global secondary indexes, if any, on the table. Each index is
     *         scoped to a given hash key value. Each element is composed of: <ul>
     *         <li> <p><i>Backfilling</i> - If true, then the index is currently in
     *         the backfilling phase. Backfilling occurs only when a new global
     *         secondary index is added to the table; it is the process by which
     *         DynamoDB populates the new index with data from the table. (This
     *         attribute does not appear for indexes that were created during a
     *         <i>CreateTable</i> operation.) </li> <li> <p><i>IndexName</i> - The
     *         name of the global secondary index. </li> <li>
     *         <p><i>IndexSizeBytes</i> - The total size of the global secondary
     *         index, in bytes. DynamoDB updates this value approximately every six
     *         hours. Recent changes might not be reflected in this value. </li> <li>
     *         <p><i>IndexStatus</i> - The current status of the global secondary
     *         index: <ul> <li> <p><i>CREATING</i> - The index is being created.
     *         </li> <li> <p><i>UPDATING</i> - The index is being updated. </li> <li>
     *         <p><i>DELETING</i> - The index is being deleted. </li> <li>
     *         <p><i>ACTIVE</i> - The index is ready for use. </li> </ul> </li> <li>
     *         <p><i>ItemCount</i> - The number of items in the global secondary
     *         index. DynamoDB updates this value approximately every six hours.
     *         Recent changes might not be reflected in this value. </li> <li>
     *         <p><i>KeySchema</i> - Specifies the complete index key schema. The
     *         attribute names in the key schema must be between 1 and 255 characters
     *         (inclusive). The key schema must begin with the same hash key
     *         attribute as the table. </li> <li> <p><i>Projection</i> - Specifies
     *         attributes that are copied (projected) from the table into the index.
     *         These are in addition to the primary key attributes and index key
     *         attributes, which are automatically projected. Each attribute
     *         specification is composed of: <ul> <li> <p><i>ProjectionType</i> - One
     *         of the following: <ul> <li> <p><code>KEYS_ONLY</code> - Only the index
     *         and primary keys are projected into the index. </li> <li>
     *         <p><code>INCLUDE</code> - Only the specified table attributes are
     *         projected into the index. The list of projected attributes are in
     *         <i>NonKeyAttributes</i>. </li> <li> <p><code>ALL</code> - All of the
     *         table attributes are projected into the index. </li> </ul> </li> <li>
     *         <p><i>NonKeyAttributes</i> - A list of one or more non-key attribute
     *         names that are projected into the secondary index. The total count of
     *         attributes provided in <i>NonKeyAttributes</i>, summed across all of
     *         the secondary indexes, must not exceed 20. If you project the same
     *         attribute into two different indexes, this counts as two distinct
     *         attributes when determining the total. </li> </ul> </li> <li>
     *         <p><i>ProvisionedThroughput</i> - The provisioned throughput settings
     *         for the global secondary index, consisting of read and write capacity
     *         units, along with data about increases and decreases. </li> </ul>
     *         <p>If the table is in the <code>DELETING</code> state, no information
     *         about indexes will be returned.
     */
    public java.util.List<GlobalSecondaryIndexDescription> getGlobalSecondaryIndexes() {
        return globalSecondaryIndexes;
    }
    
    /**
     * The global secondary indexes, if any, on the table. Each index is
     * scoped to a given hash key value. Each element is composed of: <ul>
     * <li> <p><i>Backfilling</i> - If true, then the index is currently in
     * the backfilling phase. Backfilling occurs only when a new global
     * secondary index is added to the table; it is the process by which
     * DynamoDB populates the new index with data from the table. (This
     * attribute does not appear for indexes that were created during a
     * <i>CreateTable</i> operation.) </li> <li> <p><i>IndexName</i> - The
     * name of the global secondary index. </li> <li>
     * <p><i>IndexSizeBytes</i> - The total size of the global secondary
     * index, in bytes. DynamoDB updates this value approximately every six
     * hours. Recent changes might not be reflected in this value. </li> <li>
     * <p><i>IndexStatus</i> - The current status of the global secondary
     * index: <ul> <li> <p><i>CREATING</i> - The index is being created.
     * </li> <li> <p><i>UPDATING</i> - The index is being updated. </li> <li>
     * <p><i>DELETING</i> - The index is being deleted. </li> <li>
     * <p><i>ACTIVE</i> - The index is ready for use. </li> </ul> </li> <li>
     * <p><i>ItemCount</i> - The number of items in the global secondary
     * index. DynamoDB updates this value approximately every six hours.
     * Recent changes might not be reflected in this value. </li> <li>
     * <p><i>KeySchema</i> - Specifies the complete index key schema. The
     * attribute names in the key schema must be between 1 and 255 characters
     * (inclusive). The key schema must begin with the same hash key
     * attribute as the table. </li> <li> <p><i>Projection</i> - Specifies
     * attributes that are copied (projected) from the table into the index.
     * These are in addition to the primary key attributes and index key
     * attributes, which are automatically projected. Each attribute
     * specification is composed of: <ul> <li> <p><i>ProjectionType</i> - One
     * of the following: <ul> <li> <p><code>KEYS_ONLY</code> - Only the index
     * and primary keys are projected into the index. </li> <li>
     * <p><code>INCLUDE</code> - Only the specified table attributes are
     * projected into the index. The list of projected attributes are in
     * <i>NonKeyAttributes</i>. </li> <li> <p><code>ALL</code> - All of the
     * table attributes are projected into the index. </li> </ul> </li> <li>
     * <p><i>NonKeyAttributes</i> - A list of one or more non-key attribute
     * names that are projected into the secondary index. The total count of
     * attributes provided in <i>NonKeyAttributes</i>, summed across all of
     * the secondary indexes, must not exceed 20. If you project the same
     * attribute into two different indexes, this counts as two distinct
     * attributes when determining the total. </li> </ul> </li> <li>
     * <p><i>ProvisionedThroughput</i> - The provisioned throughput settings
     * for the global secondary index, consisting of read and write capacity
     * units, along with data about increases and decreases. </li> </ul>
     * <p>If the table is in the <code>DELETING</code> state, no information
     * about indexes will be returned.
     *
     * @param globalSecondaryIndexes The global secondary indexes, if any, on the table. Each index is
     *         scoped to a given hash key value. Each element is composed of: <ul>
     *         <li> <p><i>Backfilling</i> - If true, then the index is currently in
     *         the backfilling phase. Backfilling occurs only when a new global
     *         secondary index is added to the table; it is the process by which
     *         DynamoDB populates the new index with data from the table. (This
     *         attribute does not appear for indexes that were created during a
     *         <i>CreateTable</i> operation.) </li> <li> <p><i>IndexName</i> - The
     *         name of the global secondary index. </li> <li>
     *         <p><i>IndexSizeBytes</i> - The total size of the global secondary
     *         index, in bytes. DynamoDB updates this value approximately every six
     *         hours. Recent changes might not be reflected in this value. </li> <li>
     *         <p><i>IndexStatus</i> - The current status of the global secondary
     *         index: <ul> <li> <p><i>CREATING</i> - The index is being created.
     *         </li> <li> <p><i>UPDATING</i> - The index is being updated. </li> <li>
     *         <p><i>DELETING</i> - The index is being deleted. </li> <li>
     *         <p><i>ACTIVE</i> - The index is ready for use. </li> </ul> </li> <li>
     *         <p><i>ItemCount</i> - The number of items in the global secondary
     *         index. DynamoDB updates this value approximately every six hours.
     *         Recent changes might not be reflected in this value. </li> <li>
     *         <p><i>KeySchema</i> - Specifies the complete index key schema. The
     *         attribute names in the key schema must be between 1 and 255 characters
     *         (inclusive). The key schema must begin with the same hash key
     *         attribute as the table. </li> <li> <p><i>Projection</i> - Specifies
     *         attributes that are copied (projected) from the table into the index.
     *         These are in addition to the primary key attributes and index key
     *         attributes, which are automatically projected. Each attribute
     *         specification is composed of: <ul> <li> <p><i>ProjectionType</i> - One
     *         of the following: <ul> <li> <p><code>KEYS_ONLY</code> - Only the index
     *         and primary keys are projected into the index. </li> <li>
     *         <p><code>INCLUDE</code> - Only the specified table attributes are
     *         projected into the index. The list of projected attributes are in
     *         <i>NonKeyAttributes</i>. </li> <li> <p><code>ALL</code> - All of the
     *         table attributes are projected into the index. </li> </ul> </li> <li>
     *         <p><i>NonKeyAttributes</i> - A list of one or more non-key attribute
     *         names that are projected into the secondary index. The total count of
     *         attributes provided in <i>NonKeyAttributes</i>, summed across all of
     *         the secondary indexes, must not exceed 20. If you project the same
     *         attribute into two different indexes, this counts as two distinct
     *         attributes when determining the total. </li> </ul> </li> <li>
     *         <p><i>ProvisionedThroughput</i> - The provisioned throughput settings
     *         for the global secondary index, consisting of read and write capacity
     *         units, along with data about increases and decreases. </li> </ul>
     *         <p>If the table is in the <code>DELETING</code> state, no information
     *         about indexes will be returned.
     */
    public void setGlobalSecondaryIndexes(java.util.Collection<GlobalSecondaryIndexDescription> globalSecondaryIndexes) {
        if (globalSecondaryIndexes == null) {
            this.globalSecondaryIndexes = null;
            return;
        }
        com.amazonaws.internal.ListWithAutoConstructFlag<GlobalSecondaryIndexDescription> globalSecondaryIndexesCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<GlobalSecondaryIndexDescription>(globalSecondaryIndexes.size());
        globalSecondaryIndexesCopy.addAll(globalSecondaryIndexes);
        this.globalSecondaryIndexes = globalSecondaryIndexesCopy;
    }
    
    /**
     * The global secondary indexes, if any, on the table. Each index is
     * scoped to a given hash key value. Each element is composed of: <ul>
     * <li> <p><i>Backfilling</i> - If true, then the index is currently in
     * the backfilling phase. Backfilling occurs only when a new global
     * secondary index is added to the table; it is the process by which
     * DynamoDB populates the new index with data from the table. (This
     * attribute does not appear for indexes that were created during a
     * <i>CreateTable</i> operation.) </li> <li> <p><i>IndexName</i> - The
     * name of the global secondary index. </li> <li>
     * <p><i>IndexSizeBytes</i> - The total size of the global secondary
     * index, in bytes. DynamoDB updates this value approximately every six
     * hours. Recent changes might not be reflected in this value. </li> <li>
     * <p><i>IndexStatus</i> - The current status of the global secondary
     * index: <ul> <li> <p><i>CREATING</i> - The index is being created.
     * </li> <li> <p><i>UPDATING</i> - The index is being updated. </li> <li>
     * <p><i>DELETING</i> - The index is being deleted. </li> <li>
     * <p><i>ACTIVE</i> - The index is ready for use. </li> </ul> </li> <li>
     * <p><i>ItemCount</i> - The number of items in the global secondary
     * index. DynamoDB updates this value approximately every six hours.
     * Recent changes might not be reflected in this value. </li> <li>
     * <p><i>KeySchema</i> - Specifies the complete index key schema. The
     * attribute names in the key schema must be between 1 and 255 characters
     * (inclusive). The key schema must begin with the same hash key
     * attribute as the table. </li> <li> <p><i>Projection</i> - Specifies
     * attributes that are copied (projected) from the table into the index.
     * These are in addition to the primary key attributes and index key
     * attributes, which are automatically projected. Each attribute
     * specification is composed of: <ul> <li> <p><i>ProjectionType</i> - One
     * of the following: <ul> <li> <p><code>KEYS_ONLY</code> - Only the index
     * and primary keys are projected into the index. </li> <li>
     * <p><code>INCLUDE</code> - Only the specified table attributes are
     * projected into the index. The list of projected attributes are in
     * <i>NonKeyAttributes</i>. </li> <li> <p><code>ALL</code> - All of the
     * table attributes are projected into the index. </li> </ul> </li> <li>
     * <p><i>NonKeyAttributes</i> - A list of one or more non-key attribute
     * names that are projected into the secondary index. The total count of
     * attributes provided in <i>NonKeyAttributes</i>, summed across all of
     * the secondary indexes, must not exceed 20. If you project the same
     * attribute into two different indexes, this counts as two distinct
     * attributes when determining the total. </li> </ul> </li> <li>
     * <p><i>ProvisionedThroughput</i> - The provisioned throughput settings
     * for the global secondary index, consisting of read and write capacity
     * units, along with data about increases and decreases. </li> </ul>
     * <p>If the table is in the <code>DELETING</code> state, no information
     * about indexes will be returned.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param globalSecondaryIndexes The global secondary indexes, if any, on the table. Each index is
     *         scoped to a given hash key value. Each element is composed of: <ul>
     *         <li> <p><i>Backfilling</i> - If true, then the index is currently in
     *         the backfilling phase. Backfilling occurs only when a new global
     *         secondary index is added to the table; it is the process by which
     *         DynamoDB populates the new index with data from the table. (This
     *         attribute does not appear for indexes that were created during a
     *         <i>CreateTable</i> operation.) </li> <li> <p><i>IndexName</i> - The
     *         name of the global secondary index. </li> <li>
     *         <p><i>IndexSizeBytes</i> - The total size of the global secondary
     *         index, in bytes. DynamoDB updates this value approximately every six
     *         hours. Recent changes might not be reflected in this value. </li> <li>
     *         <p><i>IndexStatus</i> - The current status of the global secondary
     *         index: <ul> <li> <p><i>CREATING</i> - The index is being created.
     *         </li> <li> <p><i>UPDATING</i> - The index is being updated. </li> <li>
     *         <p><i>DELETING</i> - The index is being deleted. </li> <li>
     *         <p><i>ACTIVE</i> - The index is ready for use. </li> </ul> </li> <li>
     *         <p><i>ItemCount</i> - The number of items in the global secondary
     *         index. DynamoDB updates this value approximately every six hours.
     *         Recent changes might not be reflected in this value. </li> <li>
     *         <p><i>KeySchema</i> - Specifies the complete index key schema. The
     *         attribute names in the key schema must be between 1 and 255 characters
     *         (inclusive). The key schema must begin with the same hash key
     *         attribute as the table. </li> <li> <p><i>Projection</i> - Specifies
     *         attributes that are copied (projected) from the table into the index.
     *         These are in addition to the primary key attributes and index key
     *         attributes, which are automatically projected. Each attribute
     *         specification is composed of: <ul> <li> <p><i>ProjectionType</i> - One
     *         of the following: <ul> <li> <p><code>KEYS_ONLY</code> - Only the index
     *         and primary keys are projected into the index. </li> <li>
     *         <p><code>INCLUDE</code> - Only the specified table attributes are
     *         projected into the index. The list of projected attributes are in
     *         <i>NonKeyAttributes</i>. </li> <li> <p><code>ALL</code> - All of the
     *         table attributes are projected into the index. </li> </ul> </li> <li>
     *         <p><i>NonKeyAttributes</i> - A list of one or more non-key attribute
     *         names that are projected into the secondary index. The total count of
     *         attributes provided in <i>NonKeyAttributes</i>, summed across all of
     *         the secondary indexes, must not exceed 20. If you project the same
     *         attribute into two different indexes, this counts as two distinct
     *         attributes when determining the total. </li> </ul> </li> <li>
     *         <p><i>ProvisionedThroughput</i> - The provisioned throughput settings
     *         for the global secondary index, consisting of read and write capacity
     *         units, along with data about increases and decreases. </li> </ul>
     *         <p>If the table is in the <code>DELETING</code> state, no information
     *         about indexes will be returned.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withGlobalSecondaryIndexes(GlobalSecondaryIndexDescription... globalSecondaryIndexes) {
        if (getGlobalSecondaryIndexes() == null) setGlobalSecondaryIndexes(new java.util.ArrayList<GlobalSecondaryIndexDescription>(globalSecondaryIndexes.length));
        for (GlobalSecondaryIndexDescription value : globalSecondaryIndexes) {
            getGlobalSecondaryIndexes().add(value);
        }
        return this;
    }
    
    /**
     * The global secondary indexes, if any, on the table. Each index is
     * scoped to a given hash key value. Each element is composed of: <ul>
     * <li> <p><i>Backfilling</i> - If true, then the index is currently in
     * the backfilling phase. Backfilling occurs only when a new global
     * secondary index is added to the table; it is the process by which
     * DynamoDB populates the new index with data from the table. (This
     * attribute does not appear for indexes that were created during a
     * <i>CreateTable</i> operation.) </li> <li> <p><i>IndexName</i> - The
     * name of the global secondary index. </li> <li>
     * <p><i>IndexSizeBytes</i> - The total size of the global secondary
     * index, in bytes. DynamoDB updates this value approximately every six
     * hours. Recent changes might not be reflected in this value. </li> <li>
     * <p><i>IndexStatus</i> - The current status of the global secondary
     * index: <ul> <li> <p><i>CREATING</i> - The index is being created.
     * </li> <li> <p><i>UPDATING</i> - The index is being updated. </li> <li>
     * <p><i>DELETING</i> - The index is being deleted. </li> <li>
     * <p><i>ACTIVE</i> - The index is ready for use. </li> </ul> </li> <li>
     * <p><i>ItemCount</i> - The number of items in the global secondary
     * index. DynamoDB updates this value approximately every six hours.
     * Recent changes might not be reflected in this value. </li> <li>
     * <p><i>KeySchema</i> - Specifies the complete index key schema. The
     * attribute names in the key schema must be between 1 and 255 characters
     * (inclusive). The key schema must begin with the same hash key
     * attribute as the table. </li> <li> <p><i>Projection</i> - Specifies
     * attributes that are copied (projected) from the table into the index.
     * These are in addition to the primary key attributes and index key
     * attributes, which are automatically projected. Each attribute
     * specification is composed of: <ul> <li> <p><i>ProjectionType</i> - One
     * of the following: <ul> <li> <p><code>KEYS_ONLY</code> - Only the index
     * and primary keys are projected into the index. </li> <li>
     * <p><code>INCLUDE</code> - Only the specified table attributes are
     * projected into the index. The list of projected attributes are in
     * <i>NonKeyAttributes</i>. </li> <li> <p><code>ALL</code> - All of the
     * table attributes are projected into the index. </li> </ul> </li> <li>
     * <p><i>NonKeyAttributes</i> - A list of one or more non-key attribute
     * names that are projected into the secondary index. The total count of
     * attributes provided in <i>NonKeyAttributes</i>, summed across all of
     * the secondary indexes, must not exceed 20. If you project the same
     * attribute into two different indexes, this counts as two distinct
     * attributes when determining the total. </li> </ul> </li> <li>
     * <p><i>ProvisionedThroughput</i> - The provisioned throughput settings
     * for the global secondary index, consisting of read and write capacity
     * units, along with data about increases and decreases. </li> </ul>
     * <p>If the table is in the <code>DELETING</code> state, no information
     * about indexes will be returned.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param globalSecondaryIndexes The global secondary indexes, if any, on the table. Each index is
     *         scoped to a given hash key value. Each element is composed of: <ul>
     *         <li> <p><i>Backfilling</i> - If true, then the index is currently in
     *         the backfilling phase. Backfilling occurs only when a new global
     *         secondary index is added to the table; it is the process by which
     *         DynamoDB populates the new index with data from the table. (This
     *         attribute does not appear for indexes that were created during a
     *         <i>CreateTable</i> operation.) </li> <li> <p><i>IndexName</i> - The
     *         name of the global secondary index. </li> <li>
     *         <p><i>IndexSizeBytes</i> - The total size of the global secondary
     *         index, in bytes. DynamoDB updates this value approximately every six
     *         hours. Recent changes might not be reflected in this value. </li> <li>
     *         <p><i>IndexStatus</i> - The current status of the global secondary
     *         index: <ul> <li> <p><i>CREATING</i> - The index is being created.
     *         </li> <li> <p><i>UPDATING</i> - The index is being updated. </li> <li>
     *         <p><i>DELETING</i> - The index is being deleted. </li> <li>
     *         <p><i>ACTIVE</i> - The index is ready for use. </li> </ul> </li> <li>
     *         <p><i>ItemCount</i> - The number of items in the global secondary
     *         index. DynamoDB updates this value approximately every six hours.
     *         Recent changes might not be reflected in this value. </li> <li>
     *         <p><i>KeySchema</i> - Specifies the complete index key schema. The
     *         attribute names in the key schema must be between 1 and 255 characters
     *         (inclusive). The key schema must begin with the same hash key
     *         attribute as the table. </li> <li> <p><i>Projection</i> - Specifies
     *         attributes that are copied (projected) from the table into the index.
     *         These are in addition to the primary key attributes and index key
     *         attributes, which are automatically projected. Each attribute
     *         specification is composed of: <ul> <li> <p><i>ProjectionType</i> - One
     *         of the following: <ul> <li> <p><code>KEYS_ONLY</code> - Only the index
     *         and primary keys are projected into the index. </li> <li>
     *         <p><code>INCLUDE</code> - Only the specified table attributes are
     *         projected into the index. The list of projected attributes are in
     *         <i>NonKeyAttributes</i>. </li> <li> <p><code>ALL</code> - All of the
     *         table attributes are projected into the index. </li> </ul> </li> <li>
     *         <p><i>NonKeyAttributes</i> - A list of one or more non-key attribute
     *         names that are projected into the secondary index. The total count of
     *         attributes provided in <i>NonKeyAttributes</i>, summed across all of
     *         the secondary indexes, must not exceed 20. If you project the same
     *         attribute into two different indexes, this counts as two distinct
     *         attributes when determining the total. </li> </ul> </li> <li>
     *         <p><i>ProvisionedThroughput</i> - The provisioned throughput settings
     *         for the global secondary index, consisting of read and write capacity
     *         units, along with data about increases and decreases. </li> </ul>
     *         <p>If the table is in the <code>DELETING</code> state, no information
     *         about indexes will be returned.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withGlobalSecondaryIndexes(java.util.Collection<GlobalSecondaryIndexDescription> globalSecondaryIndexes) {
        if (globalSecondaryIndexes == null) {
            this.globalSecondaryIndexes = null;
        } else {
            com.amazonaws.internal.ListWithAutoConstructFlag<GlobalSecondaryIndexDescription> globalSecondaryIndexesCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<GlobalSecondaryIndexDescription>(globalSecondaryIndexes.size());
            globalSecondaryIndexesCopy.addAll(globalSecondaryIndexes);
            this.globalSecondaryIndexes = globalSecondaryIndexesCopy;
        }

        return this;
    }

    /**
     * The current DynamoDB Streams configuration for the table.
     *
     * @return The current DynamoDB Streams configuration for the table.
     */
    public StreamSpecification getStreamSpecification() {
        return streamSpecification;
    }
    
    /**
     * The current DynamoDB Streams configuration for the table.
     *
     * @param streamSpecification The current DynamoDB Streams configuration for the table.
     */
    public void setStreamSpecification(StreamSpecification streamSpecification) {
        this.streamSpecification = streamSpecification;
    }
    
    /**
     * The current DynamoDB Streams configuration for the table.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param streamSpecification The current DynamoDB Streams configuration for the table.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withStreamSpecification(StreamSpecification streamSpecification) {
        this.streamSpecification = streamSpecification;
        return this;
    }

    /**
     * A timestamp, in ISO 8601 format, for this stream. <p>Note that
     * <i>LatestStreamLabel</i> is not a unique identifier for the stream,
     * because it is possible that a stream from another table might have the
     * same timestamp. However, the combination of the following three
     * elements is guaranteed to be unique: <ul> <li><p>the AWS customer
     * ID.</li> <li><p>the table name.</li> <li><p>the
     * <i>StreamLabel</i>.</li> </ul>
     *
     * @return A timestamp, in ISO 8601 format, for this stream. <p>Note that
     *         <i>LatestStreamLabel</i> is not a unique identifier for the stream,
     *         because it is possible that a stream from another table might have the
     *         same timestamp. However, the combination of the following three
     *         elements is guaranteed to be unique: <ul> <li><p>the AWS customer
     *         ID.</li> <li><p>the table name.</li> <li><p>the
     *         <i>StreamLabel</i>.</li> </ul>
     */
    public String getLatestStreamLabel() {
        return latestStreamLabel;
    }
    
    /**
     * A timestamp, in ISO 8601 format, for this stream. <p>Note that
     * <i>LatestStreamLabel</i> is not a unique identifier for the stream,
     * because it is possible that a stream from another table might have the
     * same timestamp. However, the combination of the following three
     * elements is guaranteed to be unique: <ul> <li><p>the AWS customer
     * ID.</li> <li><p>the table name.</li> <li><p>the
     * <i>StreamLabel</i>.</li> </ul>
     *
     * @param latestStreamLabel A timestamp, in ISO 8601 format, for this stream. <p>Note that
     *         <i>LatestStreamLabel</i> is not a unique identifier for the stream,
     *         because it is possible that a stream from another table might have the
     *         same timestamp. However, the combination of the following three
     *         elements is guaranteed to be unique: <ul> <li><p>the AWS customer
     *         ID.</li> <li><p>the table name.</li> <li><p>the
     *         <i>StreamLabel</i>.</li> </ul>
     */
    public void setLatestStreamLabel(String latestStreamLabel) {
        this.latestStreamLabel = latestStreamLabel;
    }
    
    /**
     * A timestamp, in ISO 8601 format, for this stream. <p>Note that
     * <i>LatestStreamLabel</i> is not a unique identifier for the stream,
     * because it is possible that a stream from another table might have the
     * same timestamp. However, the combination of the following three
     * elements is guaranteed to be unique: <ul> <li><p>the AWS customer
     * ID.</li> <li><p>the table name.</li> <li><p>the
     * <i>StreamLabel</i>.</li> </ul>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param latestStreamLabel A timestamp, in ISO 8601 format, for this stream. <p>Note that
     *         <i>LatestStreamLabel</i> is not a unique identifier for the stream,
     *         because it is possible that a stream from another table might have the
     *         same timestamp. However, the combination of the following three
     *         elements is guaranteed to be unique: <ul> <li><p>the AWS customer
     *         ID.</li> <li><p>the table name.</li> <li><p>the
     *         <i>StreamLabel</i>.</li> </ul>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withLatestStreamLabel(String latestStreamLabel) {
        this.latestStreamLabel = latestStreamLabel;
        return this;
    }

    /**
     * The Amazon Resource Name (ARN) that uniquely identifies the latest
     * stream for this table.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>37 - 1024<br/>
     *
     * @return The Amazon Resource Name (ARN) that uniquely identifies the latest
     *         stream for this table.
     */
    public String getLatestStreamArn() {
        return latestStreamArn;
    }
    
    /**
     * The Amazon Resource Name (ARN) that uniquely identifies the latest
     * stream for this table.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>37 - 1024<br/>
     *
     * @param latestStreamArn The Amazon Resource Name (ARN) that uniquely identifies the latest
     *         stream for this table.
     */
    public void setLatestStreamArn(String latestStreamArn) {
        this.latestStreamArn = latestStreamArn;
    }
    
    /**
     * The Amazon Resource Name (ARN) that uniquely identifies the latest
     * stream for this table.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>37 - 1024<br/>
     *
     * @param latestStreamArn The Amazon Resource Name (ARN) that uniquely identifies the latest
     *         stream for this table.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TableDescription withLatestStreamArn(String latestStreamArn) {
        this.latestStreamArn = latestStreamArn;
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAttributeDefinitions() != null) sb.append("AttributeDefinitions: " + getAttributeDefinitions() + ",");
        if (getTableName() != null) sb.append("TableName: " + getTableName() + ",");
        if (getKeySchema() != null) sb.append("KeySchema: " + getKeySchema() + ",");
        if (getTableStatus() != null) sb.append("TableStatus: " + getTableStatus() + ",");
        if (getCreationDateTime() != null) sb.append("CreationDateTime: " + getCreationDateTime() + ",");
        if (getProvisionedThroughput() != null) sb.append("ProvisionedThroughput: " + getProvisionedThroughput() + ",");
        if (getTableSizeBytes() != null) sb.append("TableSizeBytes: " + getTableSizeBytes() + ",");
        if (getItemCount() != null) sb.append("ItemCount: " + getItemCount() + ",");
        if (getTableArn() != null) sb.append("TableArn: " + getTableArn() + ",");
        if (getLocalSecondaryIndexes() != null) sb.append("LocalSecondaryIndexes: " + getLocalSecondaryIndexes() + ",");
        if (getGlobalSecondaryIndexes() != null) sb.append("GlobalSecondaryIndexes: " + getGlobalSecondaryIndexes() + ",");
        if (getStreamSpecification() != null) sb.append("StreamSpecification: " + getStreamSpecification() + ",");
        if (getLatestStreamLabel() != null) sb.append("LatestStreamLabel: " + getLatestStreamLabel() + ",");
        if (getLatestStreamArn() != null) sb.append("LatestStreamArn: " + getLatestStreamArn() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getAttributeDefinitions() == null) ? 0 : getAttributeDefinitions().hashCode()); 
        hashCode = prime * hashCode + ((getTableName() == null) ? 0 : getTableName().hashCode()); 
        hashCode = prime * hashCode + ((getKeySchema() == null) ? 0 : getKeySchema().hashCode()); 
        hashCode = prime * hashCode + ((getTableStatus() == null) ? 0 : getTableStatus().hashCode()); 
        hashCode = prime * hashCode + ((getCreationDateTime() == null) ? 0 : getCreationDateTime().hashCode()); 
        hashCode = prime * hashCode + ((getProvisionedThroughput() == null) ? 0 : getProvisionedThroughput().hashCode()); 
        hashCode = prime * hashCode + ((getTableSizeBytes() == null) ? 0 : getTableSizeBytes().hashCode()); 
        hashCode = prime * hashCode + ((getItemCount() == null) ? 0 : getItemCount().hashCode()); 
        hashCode = prime * hashCode + ((getTableArn() == null) ? 0 : getTableArn().hashCode()); 
        hashCode = prime * hashCode + ((getLocalSecondaryIndexes() == null) ? 0 : getLocalSecondaryIndexes().hashCode()); 
        hashCode = prime * hashCode + ((getGlobalSecondaryIndexes() == null) ? 0 : getGlobalSecondaryIndexes().hashCode()); 
        hashCode = prime * hashCode + ((getStreamSpecification() == null) ? 0 : getStreamSpecification().hashCode()); 
        hashCode = prime * hashCode + ((getLatestStreamLabel() == null) ? 0 : getLatestStreamLabel().hashCode()); 
        hashCode = prime * hashCode + ((getLatestStreamArn() == null) ? 0 : getLatestStreamArn().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof TableDescription == false) return false;
        TableDescription other = (TableDescription)obj;
        
        if (other.getAttributeDefinitions() == null ^ this.getAttributeDefinitions() == null) return false;
        if (other.getAttributeDefinitions() != null && other.getAttributeDefinitions().equals(this.getAttributeDefinitions()) == false) return false; 
        if (other.getTableName() == null ^ this.getTableName() == null) return false;
        if (other.getTableName() != null && other.getTableName().equals(this.getTableName()) == false) return false; 
        if (other.getKeySchema() == null ^ this.getKeySchema() == null) return false;
        if (other.getKeySchema() != null && other.getKeySchema().equals(this.getKeySchema()) == false) return false; 
        if (other.getTableStatus() == null ^ this.getTableStatus() == null) return false;
        if (other.getTableStatus() != null && other.getTableStatus().equals(this.getTableStatus()) == false) return false; 
        if (other.getCreationDateTime() == null ^ this.getCreationDateTime() == null) return false;
        if (other.getCreationDateTime() != null && other.getCreationDateTime().equals(this.getCreationDateTime()) == false) return false; 
        if (other.getProvisionedThroughput() == null ^ this.getProvisionedThroughput() == null) return false;
        if (other.getProvisionedThroughput() != null && other.getProvisionedThroughput().equals(this.getProvisionedThroughput()) == false) return false; 
        if (other.getTableSizeBytes() == null ^ this.getTableSizeBytes() == null) return false;
        if (other.getTableSizeBytes() != null && other.getTableSizeBytes().equals(this.getTableSizeBytes()) == false) return false; 
        if (other.getItemCount() == null ^ this.getItemCount() == null) return false;
        if (other.getItemCount() != null && other.getItemCount().equals(this.getItemCount()) == false) return false; 
        if (other.getTableArn() == null ^ this.getTableArn() == null) return false;
        if (other.getTableArn() != null && other.getTableArn().equals(this.getTableArn()) == false) return false; 
        if (other.getLocalSecondaryIndexes() == null ^ this.getLocalSecondaryIndexes() == null) return false;
        if (other.getLocalSecondaryIndexes() != null && other.getLocalSecondaryIndexes().equals(this.getLocalSecondaryIndexes()) == false) return false; 
        if (other.getGlobalSecondaryIndexes() == null ^ this.getGlobalSecondaryIndexes() == null) return false;
        if (other.getGlobalSecondaryIndexes() != null && other.getGlobalSecondaryIndexes().equals(this.getGlobalSecondaryIndexes()) == false) return false; 
        if (other.getStreamSpecification() == null ^ this.getStreamSpecification() == null) return false;
        if (other.getStreamSpecification() != null && other.getStreamSpecification().equals(this.getStreamSpecification()) == false) return false; 
        if (other.getLatestStreamLabel() == null ^ this.getLatestStreamLabel() == null) return false;
        if (other.getLatestStreamLabel() != null && other.getLatestStreamLabel().equals(this.getLatestStreamLabel()) == false) return false; 
        if (other.getLatestStreamArn() == null ^ this.getLatestStreamArn() == null) return false;
        if (other.getLatestStreamArn() != null && other.getLatestStreamArn().equals(this.getLatestStreamArn()) == false) return false; 
        return true;
    }
    
}
    