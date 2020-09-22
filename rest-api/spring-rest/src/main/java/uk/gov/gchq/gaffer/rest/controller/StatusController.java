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

package uk.gov.gchq.gaffer.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.core.exception.Status;
import uk.gov.gchq.gaffer.rest.SystemStatus;
import uk.gov.gchq.gaffer.rest.factory.GraphFactory;

import static uk.gov.gchq.gaffer.rest.ServiceConstants.GAFFER_MEDIA_TYPE;
import static uk.gov.gchq.gaffer.rest.ServiceConstants.GAFFER_MEDIA_TYPE_HEADER;

@RestController
public class StatusController implements IStatusController {

    private GraphFactory graphFactory;

    @Autowired
    public void setGraphFactory(final GraphFactory graphFactory) {
        this.graphFactory = graphFactory;
    }

    @Override
    public ResponseEntity<SystemStatus> getStatus() {
        try {
            if (graphFactory.getGraph() != null) {
                return ResponseEntity.ok()
                        .header(GAFFER_MEDIA_TYPE_HEADER)
                        .body(SystemStatus.UP);
            }
        } catch (final Exception e) {
            throw new GafferRuntimeException("Unable to create graph.", e, Status.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity
                .status(503)
                .header(GAFFER_MEDIA_TYPE_HEADER, GAFFER_MEDIA_TYPE)
                .body(SystemStatus.DOWN);
    }
}