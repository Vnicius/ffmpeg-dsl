package ffmpegcommand.initializer

import ffmpegcommand.argument.Argument

open class CommandInitializer {
    protected val arguments: MutableList<Argument> = mutableListOf()

    fun getArgumentsList(): List<Argument> = arguments
}