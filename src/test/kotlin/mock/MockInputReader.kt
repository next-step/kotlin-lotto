package mock

class MockInputReader(
    private val inputs: List<String>,
) {

    private var index = 0

    fun raedLine(): String = if (index < inputs.size) inputs[index++] else ""
}
