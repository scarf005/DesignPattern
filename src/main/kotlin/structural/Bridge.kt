package structural

private const val maxVolume = 100

// @formatter:off
interface Device {
    var isEnabled: Boolean
    fun toggleEnabled() { isEnabled = !isEnabled }
    var volume: Int
    var volumePercentage: Int
        get() = volume * 100 / maxVolume
        set(value) { volume = value * maxVolume / 100 }
    var channel: Int
}

open class RemoteControl(protected val device: Device): Device by device {
    fun volumeDown() { volume -= 10 }
    fun volumeUp() { volume += 10 }
    fun channelDown() { channel-- }
    fun channelUp() { channel++ }
    override fun toString() = "volume: $volumePercentage%, channel: $channel"

}

class AdvancedRemoteControl(device: Device) : RemoteControl(device) {
    fun mute() { device.volume = 0 }
}
// @formatter:on

class Tv : Device {
    override var isEnabled = false
    override var volume = 30
    override var channel = 10
}

class Radio : Device {
    override var isEnabled = true
    override var volume = 50
    override var channel = 5
}

fun main() {
    val tv = Tv()
    RemoteControl(tv).apply {
        volumeUp()
        channelDown()
    }.also(::println)

    val radio = Radio()
    AdvancedRemoteControl(radio).apply {
        volumeDown()
        mute()
        channelUp()
    }.also(::println)
}
