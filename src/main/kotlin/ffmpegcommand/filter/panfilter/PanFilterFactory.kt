package ffmpegcommand.filter.panfilter

object PanFilterFactory {
    fun create(channelType: ChannelType, gains: FloatArray): PanFilter =
        when(channelType) {
            ChannelType.Mono -> MonoPanFilter(gains)
            ChannelType.Stereo -> StereoPanFilter(gains)
        }
}