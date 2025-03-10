/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netease.arctic.hive.formats;

import com.netease.arctic.ams.api.properties.CatalogMetaProperties;
import com.netease.arctic.formats.MixedIcebergHadoopCatalogTestHelper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.iceberg.CatalogProperties;

import java.util.HashMap;
import java.util.Map;

public class MixedIcebergHiveCatalogTestHelper extends MixedIcebergHadoopCatalogTestHelper {

  public MixedIcebergHiveCatalogTestHelper(
      String catalogName, Map<String, String> catalogProperties) {
    super(catalogName, catalogProperties);
  }

  @Override
  public void initHiveConf(Configuration hiveConf) {
    catalogProperties.put(
        CatalogProperties.URI, hiveConf.get(HiveConf.ConfVars.METASTOREURIS.varname));
  }

  protected String getMetastoreType() {
    return CatalogMetaProperties.CATALOG_TYPE_HIVE;
  }

  public static MixedIcebergHiveCatalogTestHelper defaultHelper() {
    return new MixedIcebergHiveCatalogTestHelper(
        "test_mixed_iceberg_hive_catalog", new HashMap<>());
  }
}
