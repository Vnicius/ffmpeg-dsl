package ffmpegcommand.argument

open class TimePositionArgument(override val key: String): Argument() {
    override val value: String
        get() = position
    private var position: String = ""

    fun setPosition(seconds: Int) {
        position = seconds.toString()
    }

    fun setPosition(seconds: Float) {
        position = seconds.toString()
    }

    fun setPosition(milliseconds: Long) {
        position = "${milliseconds}ms"
    }

    fun setPosition(position: String) {
        this.position = position
    }
}