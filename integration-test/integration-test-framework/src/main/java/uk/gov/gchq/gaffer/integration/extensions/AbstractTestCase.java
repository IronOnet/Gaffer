/*
 * Copyright 2020 Crown Copyright
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

package uk.gov.gchq.gaffer.integration.extensions;

import uk.gov.gchq.gaffer.graph.Graph;
import uk.gov.gchq.gaffer.store.StoreProperties;

public abstract class AbstractTestCase {
    private final StoreProperties storeProperties;

    public AbstractTestCase(final StoreProperties storeProperties) {
        this.storeProperties = storeProperties;
    }

    public StoreProperties getStoreProperties() {
        return storeProperties;
    }

    protected abstract Graph getGraph();

    protected String getTestName() {
        String storeClass = storeProperties.getStoreClass();
        return storeClass.substring(storeClass.lastIndexOf(".") + 1);
    }
}
