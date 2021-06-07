package ffmpegcommand.filter.panfilter

class StereoPanFilter(gains: FloatArray) : PanFilter(ChannelType.Stereo, gains) {
    init {
        setupChannelsGain(gains)
    }

    private fun setupChannelsGain(gains: FloatArray) {
        val channelsConfigs = gains.mapIndexed { index, value ->
            "c$index<c$index*$value"
        }

        channelsConfigs.forEach(::addChannelConfig)
    }
}