package ffmpegcommand.filter.panfilter

import ffmpegcommand.filter.Filter

open class PanFilter(private val channelType: ChannelType, protected val gains: FloatArray) : Filter() {
    override val key: String = "pan"
    override val value: String
        get() = getChannelsAsString()

    private val channelsConfigs: MutableList<String> = mutableListOf()

    private fun getChannelsAsString(): String {
        val separator = "|"
        val channels = channelsConfigs.joinToString(separator)

        return "${channelType.value}$separator$channels"
    }

    fun addChannelConfig(channelConfig: String) {
        channelsConfigs.add(channelConfig)
    }
}