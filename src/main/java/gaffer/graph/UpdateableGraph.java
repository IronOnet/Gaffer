/**
 * Copyright 2015 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gaffer.graph;

import gaffer.GraphAccessException;
import gaffer.graph.wrappers.GraphElement;
import gaffer.graph.wrappers.GraphElementWithStatistics;

/**
 * If a graph implements this interface then {@link GraphElementWithStatistics} can be added
 * to it.
 * 
 * Note that this interface is used for graphs that can accept updates in near real time, and
 * does not relate to bulk imports.
 */
public interface UpdateableGraph {

	/**
	 * Adds {@link GraphElement}s from the provided {@link Iterable}.
	 * 
	 * @param graphElements
	 * @throws GraphAccessException 
	 */
	void addGraphElements(Iterable<GraphElement> graphElements) throws GraphAccessException;
	
	/**
	 * Adds {@link GraphElementWithStatistics}s from the provided {@link Iterable}.
	 * 
	 * @param graphElementsWithStatistics
	 * @throws GraphAccessException
	 */
	void addGraphElementsWithStatistics(Iterable<GraphElementWithStatistics> graphElementsWithStatistics) throws GraphAccessException;
}
