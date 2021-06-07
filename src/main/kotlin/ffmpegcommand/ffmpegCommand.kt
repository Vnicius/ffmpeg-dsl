package ffmpegcommand

import ffmpegcommand.command.CommandBuilder
import ffmpegcommand.initializer.FFmpegCommandInitializer

fun ffmpegCommand(initializer: FFmpegCommandInitializer.() -> Unit): String {
    val ffmpegCommandInitializer = FFmpegCommandInitializer()
    val commandBuilder = CommandBuilder()

    ffmpegCommandInitializer.initializer()

    ffmpegCommandInitializer.getArgumentsList().forEach {
        commandBuilder.addArgument(it)
    }

    return commandBuilder.toString()
}