package ffmpegcommand.initializer

import ffmpegcommand.filter.panfilter.ChannelType

class PanInitializer {
    var channelType: ChannelType = ChannelType.Mono
    var gains: FloatArray = floatArrayOf()
}