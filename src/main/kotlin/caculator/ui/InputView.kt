package caculator.ui

class InputView(private val inputStrategy: InputStrategy) {
    val value = tryEnterInput()

    constructor(inputStrategy: InputStrategy, question: String) : this(inputStrategy) {
        println(question)
    }

    private fun tryEnterInput(): String {
        return inputStrategy.enter()
            ?: throw IllegalArgumentException("입력값이 비어 있습니다")
    }
}
