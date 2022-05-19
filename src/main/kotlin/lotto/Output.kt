package lotto

interface IOutput {
    fun print(message: String)
}

class Output : IOutput {
    override fun print(message: String) {
        println(message)
    }
}