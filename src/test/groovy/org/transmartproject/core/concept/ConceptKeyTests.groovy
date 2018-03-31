/*
 * Copyright © 2013-2014 The Hyve B.V.
 *
 * This file is part of transmart-core-api.
 *
 * Transmart-core-api is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * transmart-core-api.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.transmartproject.core.concept

import org.junit.Test

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.allOf
import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.Matchers.hasProperty
import static org.hamcrest.Matchers.isA
import static org.junit.Assert.fail

class ConceptKeyTests {

	@Test
	void basicTest() {
		ConceptKey conceptKey = new ConceptKey('\\\\tableCode\\full\\thing\\')

		assertThat conceptKey, allOf(
				hasProperty('tableCode', equalTo('tableCode')),
				hasProperty('conceptFullName', hasProperty('length',
						equalTo(2))))
	}

	@Test
	void basicTestAlternativeConstructor() {
		assert new ConceptKey('tableCode', '\\full\\thing\\') ==
				new ConceptKey('\\\\tableCode\\full\\thing\\')
	}

	@Test
	void badInput() {
		for (String key in ['', '\\\\', '\\\\\\', '\\\\a\\', '\\as\\b', '\\\\a\\b\\\\', null]) {
			try {
				new ConceptKey(key)
				fail 'Could create ConceptKey with value ' + key
			}
			catch (e) {
				assertThat e, isA(IllegalArgumentException)
			}
		}
	}
}
