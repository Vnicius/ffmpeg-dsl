package ffmpegcommand.initializer

import ffmpegcommand.filter.DropoutTransitionFilter
import ffmpegcommand.filter.Duration
import ffmpegcommand.filter.DurationFilter
import ffmpegcommand.filter.InputsFilter
import ffmpegcommand.filter.mixfilter.AudioMixFilter

class AudioMixInitializer {
    val audioMixFilter = AudioMixFilter()
    var inputs: Int? = null
        set(value) {
            field = value
            value?.let(::addInputsFilter)
        }
    var duration: Duration? = null
        set(value) {
            field = value
            value?.let(::addDurationFilter)
        }
    var dropoutTransition: Int? = null
        set(value) {
            field = value
            value?.let(::addDropoutTransitionFilter)
        }

    private fun addInputsFilter(inputsSize: Int) {
        audioMixFilter.addFilter(InputsFilter(inputsSize))
    }

    private fun addDurationFilter(duration: Duration) {
        audioMixFilter.addFilter(DurationFilter(duration))
    }

    private fun addDropoutTransitionFilter(dropoutTransition: Int) {
        audioMixFilter.addFilter(DropoutTransitionFilter(dropoutTransition))
    }
}