package ffmpegcommand.initializer

import ffmpegcommand.filter.*
import ffmpegcommand.filter.panfilter.PanFilter
import ffmpegcommand.filter.panfilter.PanFilterFactory

abstract class BaseFiltersInitializer {
    var audioSampleRate: Float? = null
        set(value) {
            field = value
            value?.let(::addAudioSampleRateFilter)
        }
    var audioResampleRate: Float? = null
        set(value) {
            field = value
            value?.let(::addAudioResampleRateFilter)
        }
    var audioTempo: Float? = null
        set(value) {
            field = value
            value?.let(::addAudioTempoFilter)
        }
    var volume: Number? = null
        set(value) {
            field = value
            value?.let(::addVolumeFilter)
        }


    private fun addAudioSampleRateFilter(sampleRate: Float) {
        addFilter(AudioSampleRateFilter(sampleRate))
    }

    private fun addAudioResampleRateFilter(resampleRate: Float) {
        addFilter(AudioResampleFilter(resampleRate))
    }

    private fun addAudioTempoFilter(tempo: Float) {
        addFilter(AudioTempoFilter(tempo))
    }

    private fun addVolumeFilter(volume: Number) {
        addFilter(VolumeFilter(volume))
    }

    fun pan(initializer: PanInitializer.() -> Unit): PanFilter {
        val panInitializer = PanInitializer().apply(initializer)
        val panFilter = PanFilterFactory.create(panInitializer.channelType, panInitializer.gains)

        addFilter(panFilter)

        return panFilter
    }

    abstract fun addFilter(filter: Filter)
}