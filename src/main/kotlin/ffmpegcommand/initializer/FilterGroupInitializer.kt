package ffmpegcommand.initializer

import ffmpegcommand.filter.*

class FilterGroupInitializer(inputTag: String? = null, outputTag: String? = null) : BaseFiltersInitializer() {
    val filterGroup: FilterGroup = FilterGroup(inputTag, outputTag)

    override fun addFilter(filter: Filter) {
        filterGroup.addFilter(filter)
    }
}