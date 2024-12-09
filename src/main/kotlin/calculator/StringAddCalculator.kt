package calculator

import calculator.domain.AddCalculator
import calculator.domain.InputTokenizer

class StringAddCalculator {
    fun startCalculator() {
        val inputView = InputView()
        val inputString = inputView.inputUser()
        val sumResult = add(inputString)
        println("계산 결과 : $sumResult")
    }

    fun add(userInput: String? = ""): Int {
        val tokenIterator = InputTokenizer(userInput).getTokensIterator()
        val calculator = AddCalculator()
        while (tokenIterator.hasNext()) {
            calculator.add(tokenIterator.next().toInt())
        }
        println("계산 결과 : ${calculator.getResult()}")
        return calculator.getResult()
    }
}

fun main() {
    val app = StringAddCalculator()
    app.startCalculator()
}
