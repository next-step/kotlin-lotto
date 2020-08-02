package lotto

import lotto.domain.Lotto
import lotto.domain.SixNumbers
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    try {
        val money = InputView.inputMoney()
        val candidateNumbers = makeCandidateNumbers()
        val lotto = Lotto(money, candidateNumbers)
        val resultView = ResultView()
        resultView.viewSixNumbers(lotto.amount, lotto.list)
        val correctNumbers = SixNumbers(InputView.inputCorrectNumbers())
        val result = lotto.result(correctNumbers)
        resultView.viewResult(result)
    } catch (e: NumberFormatException) {
        println(e.message)
    }
}

fun makeCandidateNumbers(): List<String> {
    val list = mutableListOf<String>()
    for (number in 1..45) {
        list.add(number.toString())
    }
    return list
}
