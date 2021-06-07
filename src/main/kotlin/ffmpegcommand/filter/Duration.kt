package ffmpegcommand.filter

enum class Duration(val value: String) {
    First("first"),
    Shortest("shortest"),
    Longest("longest")
}