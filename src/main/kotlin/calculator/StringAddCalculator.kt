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

    fun add(userInput: String?): Int {
        val tokenizer = InputTokenizer(userInput ?: "0")

        val calculator = AddCalculator()
        tokenizer.getTokens().forEach {
            calculator.add(it.toIntOrNull())
        }

        println("계산 결과 : ${calculator.getResult()}")
        return calculator.getResult()
    }
}

fun main() {
    val app = StringAddCalculator()
    app.startCalculator()
}
