package lotto.view

interface Output {
    fun print(message: String)
}

class PrintOutput : Output {
    override fun print(message: String) {
        println(message)
    }
}
