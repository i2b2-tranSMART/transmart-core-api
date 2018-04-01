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

import spock.lang.Specification

class ConceptKeySpec extends Specification {

	void 'basic test'() {
		when:
		ConceptKey conceptKey = new ConceptKey('\\\\tableCode\\full\\thing\\')

		then:
		conceptKey.tableCode == 'tableCode'
		conceptKey.conceptFullName.length == 2
		conceptKey.conceptFullName[0] == 'full'
		conceptKey.conceptFullName[1] == 'thing'
	}

	void 'basic test alternative constructor'() {
		expect:
		new ConceptKey('tableCode', '\\full\\thing\\') ==
		new ConceptKey('\\\\tableCode\\full\\thing\\')
	}

	void 'bad input'(String key) {
		when:
		new ConceptKey(key)

		then:
		thrown IllegalArgumentException

		where:
		key << ['', '\\\\', '\\\\\\', '\\\\a\\', '\\as\\b', '\\\\a\\b\\\\', null]
	}
}
