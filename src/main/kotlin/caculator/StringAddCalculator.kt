package caculator

import caculator.ui.Input

class StringAddCalculator(private val input: Input) {
    fun calculate(): Int {
        return input.numbers.fold(0) { sum, element -> sum + element }
    }
}
