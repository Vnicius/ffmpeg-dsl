package ffmpegcommand.initializer

import ffmpegcommand.argument.FilterComplexArgument
import ffmpegcommand.filter.Filter
import ffmpegcommand.filter.FilterGroup
import ffmpegcommand.filter.mixfilter.AudioMixFilter

class FilterComplexInitializer {
    val filterComplexArgument: FilterComplexArgument = FilterComplexArgument()

    fun filterGroup(
        inputTag: String? = null,
        outputTag: String? = null,
        initializer: FilterGroupInitializer.() -> Unit
    ): FilterGroup {
        val filterGroupInitializer = FilterGroupInitializer(inputTag, outputTag).apply(initializer)
        val filterGroup = filterGroupInitializer.filterGroup

        filterComplexArgument.addFilterGroup(filterGroup)

        return filterGroup
    }

    fun filters(initializer: FiltersInitializer.() -> Unit): List<Filter> {
        val filterInitializer = FiltersInitializer().apply(initializer)
        val filters = filterInitializer.filters

        filters.forEach {
            filterComplexArgument.addFilter(it)
        }

        return filters
    }

    fun amix(initializer: AudioMixInitializer.() -> Unit): AudioMixFilter {
        val audioMixInitializer = AudioMixInitializer().apply(initializer)
        val audioMixFilter = audioMixInitializer.audioMixFilter

        filterComplexArgument.addFilter(audioMixFilter)

        return audioMixFilter
    }
}