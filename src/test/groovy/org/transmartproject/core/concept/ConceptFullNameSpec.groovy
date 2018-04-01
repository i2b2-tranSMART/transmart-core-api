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

class ConceptFullNameSpec extends Specification {

	void 'basic test'() {
		when:
		ConceptFullName conceptFullName = new ConceptFullName('\\abc\\d\\e')

		then:
		conceptFullName.length == 3
		conceptFullName[0] == 'abc'
		conceptFullName[1] == 'd'
		conceptFullName[2] == 'e'
		conceptFullName[3] == null
		conceptFullName[-2] == 'd'
	}

	void 'trailing slash is optional'() {
		when:
		ConceptFullName c1 = new ConceptFullName('\\a')
		ConceptFullName c2 = new ConceptFullName('\\a\\')

		then:
		c1 == c2
	}

	void 'test bad paths'(String path) {
		when:
		new ConceptFullName(path)

		then:
		thrown IllegalArgumentException

		where:
		path << ['', '\\', '\\\\', '\\a\\\\', '\\a\\\\b']
	}
}
