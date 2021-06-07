package ffmpegcommand.initializer

import ffmpegcommand.filter.Filter

class FiltersInitializer: BaseFiltersInitializer() {
    private val mutableFilters: MutableList<Filter> = mutableListOf()
    val filters: List<Filter> = mutableFilters

    override fun addFilter(filter: Filter) {
        mutableFilters.add(filter)
    }
}