/*
 * Copyright 2016-2017 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.hbasestore.utils;

import org.apache.hadoop.hbase.util.Bytes;

public final class HBaseStoreConstants {
    private HBaseStoreConstants() {
    }

    public static byte[] getColFam() {
        return Bytes.toBytes("e"); // e - for Elements/Edges/Entities
    }

    // Coprocessor options
    public static final String VIEW = "View";
    public static final String SCHEMA = "Schema";
    public static final String EXTRA_PROCESSORS = "ExtraProcessors";
    public static final String DIRECTED_TYPE = "DirectedType";

    // Operations options
    public static final String OPERATION_HDFS_STAGING_PATH = "hbasestore.operation.hdfs.staging.path";
    public static final String ADD_ELEMENTS_FROM_HDFS_SKIP_IMPORT = "hbasestore.operation.hdfs.skip_import";
    public static final String OPERATION_RETURN_MATCHED_SEEDS_AS_EDGE_SOURCE = "hbasestore.operation.return_matched_id_as_edge_source";

    // Bytes
    public static final byte[] EMPTY_BYTES = new byte[0];
    public static final byte ENTITY = (byte) 1;
    public static final byte UNDIRECTED_EDGE = (byte) 4;
    public static final byte CORRECT_WAY_DIRECTED_EDGE = (byte) 2;
    public static final byte INCORRECT_WAY_DIRECTED_EDGE = (byte) 3;
}
