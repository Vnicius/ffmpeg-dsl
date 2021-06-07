package ffmpegcommand.argument

class InputArgument(path: String): Argument() {
    override val key: String = "-i"
    override val value: String = path
}