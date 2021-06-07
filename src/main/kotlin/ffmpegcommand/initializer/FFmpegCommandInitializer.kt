package ffmpegcommand.initializer

import ffmpegcommand.argument.Argument
import ffmpegcommand.argument.FilterComplexArgument
import ffmpegcommand.argument.OutputPathValue
import ffmpegcommand.argument.OverrideAllowedFlag

class FFmpegCommandInitializer: CommandInitializer() {
    var isOverrideAllowed: Boolean? = null
        set(value) {
            field = value
            value?.let(::addIsOverrideAllowed)
        }
    var output: String? = null
        set(value) {
            field = value
            value?.let(::addOutputPathValue)
        }

    private fun addIsOverrideAllowed(isAllowed: Boolean) {
        arguments.add(OverrideAllowedFlag(isAllowed))
    }

    private fun addOutputPathValue(path: String) {
        arguments.add(OutputPathValue(path))
    }

    fun input(initializer: InputCommandInitializer.() -> Unit): List<Argument> {
        val inputCommandInitializer = InputCommandInitializer().apply(initializer)
        val argumentsList = inputCommandInitializer.getArgumentsList()

        arguments.addAll(argumentsList)

        return argumentsList
    }

    fun filterComplex(initializer: FilterComplexInitializer.() -> Unit): FilterComplexArgument {
        val filterComplexInitializer = FilterComplexInitializer().apply(initializer)
        val filterComplexArgument = filterComplexInitializer.filterComplexArgument

        arguments.add(filterComplexArgument)

        return filterComplexArgument
    }
}