package textcalculator

class MockUpIOManager(val input: String?) : IOManager {
    val buffer = StringBuffer()

    override fun input() = input

    override fun output(message: String) {
        buffer.append(message)
    }

    override fun toString() = buffer.toString()
}
