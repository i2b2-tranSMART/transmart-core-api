package org.transmartproject.core.dataquery.highdim.projections

interface MultiValueProjection {

	/**
	 * Returns a map with the keys/properties and types that are available in the object returned by
	 * queries using this projection.
	 */
	Map<String, Class> getDataProperties()
}
