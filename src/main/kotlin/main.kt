import ffmpegcommand.ffmpegCommand
import ffmpegcommand.filter.Duration
import ffmpegcommand.filter.panfilter.ChannelType

fun main(args: Array<String>) {
    val cmd = ffmpegCommand {
        isOverrideAllowed = true

        input {
            seekStartSeconds = 1.3f
            path = "this.mp4"
        }

        input {
            seekStartSeconds = 1.3f
            timeSeconds = 2.0f
            path = "this213123.mp4"
        }

        filterComplex {
            filterGroup {
                audioSampleRate = 44100 * 0.92f
                audioResampleRate = 44100f
                audioTempo = 1/0.92f
                audioTempo = 1.2f
                volume = .9f

                pan {
                    channelType = ChannelType.Stereo
                    gains = floatArrayOf(1f, 1.2f)
                }
            }

            filterGroup {
                audioSampleRate = 44100f
            }

            amix {
                inputs = 2
                duration = Duration.Longest
                dropoutTransition = 0
            }

            filters {
                volume = 2
            }
        }

        output = "test.mp3"
    }

    println(cmd)
}