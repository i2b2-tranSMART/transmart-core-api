package org.transmartproject.core.dataquery.highdim.dataconstraints

/**
 * Identifies a data constraint, that is, a constraint that will limit the
 * rows returned in a result set.
 *
 * This is only a marker interface.
 *
 * Some constants that identify well-know, general constraints are included.
 * This interface should only include constants for constraints that are
 * expected to be support in a significant number of different analyses.
 */
interface DataConstraint {

	/**
	 * A well-known constraint for filtering rows related to a certain
	 * search keyword. This includes genes, pathways and whatever else is
	 * stored as search keywords.
	 *
	 * NOTE: This is actually a pretty unsatisfactory constraint because
	 *       it leaks implementation details like a sieve. However, the
	 *       frontend currently sends these ids, so we have to deal with it.
	 *       A possibly better constraint would receive the actual keyword
	 *       (e.g. gene name) and entity type (e.g. gene) and work with that
	 *       instead of numeric ids.
	 *
	 * Parameters: 'keyword_ids' => <List of keyword ids (PK of search_keyword)>
	 */
	String SEARCH_KEYWORD_IDS_CONSTRAINT = 'search_keyword_ids'

	/**
	 * A well-known constraint for filtering rows relevant to a certain
	 * chromosome segment.
	 *
	 * Parameters: 'chromosome' => <string with chromosome number, X or Y>
	 *             'start'      => <integer with start position (inclusive)>
	 *             'end'        => <integer with end position (inclusive)>
	 */
	String CHROMOSOME_SEGMENT_CONSTRAINT = 'chromosome_segment'

	/**
	 * A well-known constraint for building a disjunction of several
	 * sub-constraints.
	 *
	 * Parameters: 'subconstraints' => <map with string key (the constraint
	 *                                  name) and a map value (the parameters of
	 *                                  the sub-constraint) or a list of maps
	 *                                  value (for several constraints of the
	 *                                  same type)>
	 */
	String DISJUNCTION_CONSTRAINT = 'disjunction'

	/**
	 * Filter rows relevant to some genes. Prefer this to
	 * {@link #SEARCH_KEYWORD_IDS_CONSTRAINT}.
	 *
	 * Parameters: 'names' => <list of gene names>
	 *             XOR
	 *             'ids' => <list of public gene ids (NCBI Gene accession)>
	 */
	String GENES_CONSTRAINT = 'genes'

	/**
	 * Filter rows relevant to some proteins. Prefer this to
	 * {@link #SEARCH_KEYWORD_IDS_CONSTRAINT}.
	 *
	 * Parameters: 'names' => <list of protein names>
	 *             XOR
	 *             'ids'  => <list of UniProt ids>
	 */
	String PROTEINS_CONSTRAINT = 'proteins'

	/**
	 * Filter rows relevant to some pathways. Prefer this to
	 * {@link #SEARCH_KEYWORD_IDS_CONSTRAINT}.
	 *
	 * Parameters: 'names' => <list of pathway names>
	 *             XOR
	 *             'ids' => <list of names in the form
	 *                       <database>:<db specific id>>
	 */
	String PATHWAYS_CONSTRAINT = 'pathways'

	/**
	 * Filter rows relevant to some gene signatures. Prefer this to
	 * {@link #SEARCH_KEYWORD_IDS_CONSTRAINT}.
	 *
	 * Parameters: 'names' => <list of pathway names>
	 *             XOR
	 *             'ids' => <list of gene signature ids>
	 */
	String GENE_SIGNATURES_CONSTRAINT = 'gene_signatures'

	/**
	 * Filter rows based on a property
	 *
	 * Parameters: 'operator' => name of the criteria to apply (e.g. 'lt', 'in', 'ilike', ...)
	 *             'property' => property of the row to check
	 *             'operand'  => the object to compare the property to (e.g. a collection if operator == 'in', a string if operator == 'ilike', ...)
	 */
	String PROPERTY_CONSTRAINT = 'property'

	/**
	 * Filter rows based on the annotation/platform associated with the high dimensional data
	 *
	 * Parameters: 'property' => name of the annotation property to search in
	 *             'term'     => string the property should match exactly
	 *            (
	 *             'concept_key'  => concept key of the high dimensional concept
	 *             XOR
	 *             'concept_code' => concept code of the high dimensional concept
	 *            )
	 */
	String ANNOTATION_CONSTRAINT = 'annotation'
}
