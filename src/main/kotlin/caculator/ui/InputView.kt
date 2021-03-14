package caculator.ui

import jdk.internal.joptsimple.internal.Strings

class InputView(private val inputStrategy: InputStrategy) {
    val value = Input(tryEnterInput())

    constructor(inputStrategy: InputStrategy, question: String) : this(inputStrategy) {
        println(question)
    }

    private fun tryEnterInput(): String {
        return inputStrategy.enter()
            ?: Strings.EMPTY
    }
}
