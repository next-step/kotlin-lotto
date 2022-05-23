package lotto.view

class StubInput(private val texts: List<String>) : Input {
    private var index = 0

    override fun read(): String = texts[index++]
}

class StubOutput : Output {
    private val messages = mutableListOf<String>()

    override fun print(message: String) {
        messages.add(message)
    }

    fun getLines(): List<String> = messages
}

class StubIO(texts: List<String> = emptyList()) : IO {
    private val input = StubInput(texts)
    private val output = StubOutput()

    override fun read(): String = input.read()

    override fun print(message: String) = output.print(message)

    fun getLines(): List<String> = output.getLines()
}
