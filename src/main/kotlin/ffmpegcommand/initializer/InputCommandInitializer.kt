package ffmpegcommand.initializer

import ffmpegcommand.argument.Argument
import ffmpegcommand.argument.InputArgument
import ffmpegcommand.argument.SeekStartArgument
import ffmpegcommand.argument.TimeArgument

class InputCommandInitializer : CommandInitializer() {
    var path: String = ""
        set(value) {
            field = value
            addInputArgument(path)
        }
    var seekStartSeconds: Float? = null
        set(value) {
            field = value
            value?.let(::addSeekStartSecondArgument)
        }
    var timeSeconds: Float? = null
        set(value) {
            field = value
            value?.let(::addTimeSecondArgument)
        }

    private fun addInputArgument(path: String) {
        arguments.add(InputArgument(path))
    }

    private fun addSeekStartSecondArgument(second: Float) {
        arguments.add(SeekStartArgument().apply {
            setPosition(second)
        })
    }

    private fun addTimeSecondArgument(second: Float) {
        arguments.add(TimeArgument().apply {
            setPosition(second)
        })
    }
}