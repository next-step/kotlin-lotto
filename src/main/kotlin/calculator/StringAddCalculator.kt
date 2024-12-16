package calculator

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
        val hasMinus =
            tokenizer.getTokens().any {
                it < 0
            }
        if (hasMinus) throw RuntimeException("자연수로 입력해 주세요.")
        val result = tokenizer.getTokens().sum()

        println("계산 결과 : $result")
        return result
    }
}

fun main() {
    val app = StringAddCalculator()
    app.startCalculator()
}
