package lotto.view

class ConsoleOutput : Output {
    override fun print(message: String) {
        println(message)
    }
}

class ConsoleInput : Input {
    override fun read(): String = readLine() ?: ""
}

class Console : IO, Input by ConsoleInput(), Output by ConsoleOutput()
