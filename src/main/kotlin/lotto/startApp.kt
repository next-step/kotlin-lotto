package lotto

import lotto.domain.Result
import lotto.domain.Lotto
import lotto.domain.Number
import lotto.view.InputView
import lotto.view.ResultView

val CANDIDATE_NUMBERS = makeCandidateNumbers()

fun main() {
    try {
        startApp()
    } catch (e: NumberFormatException) {
        println(e.message)
    }
}

fun startApp() {
    val money = InputView.inputMoney()
    val amount = money / 1000
    val lottos = makeLottos(amount)
    ResultView.viewLottos(amount, lottos)
    val correctNumbers = InputView.inputCorrectNumbers()
    checkCorrectLotto(correctNumbers, lottos)
    val result = Result(lottos)
    ResultView.viewResult(result.getAllMatchResult(), result.getRateOfReturn(money))
}

fun makeCandidateNumbers(): List<String> {
    val list = mutableListOf<Int>()
    for (number in 1..45) {
        list.add(number)
    }
    return list.map { it.toString() }
}

fun makeLottos(amount: Int): List<Lotto> {
    val list = mutableListOf<Int>()
    for (number in 1..amount) {
        list.add(number)
    }
    return list.map { Lotto(CANDIDATE_NUMBERS.shuffled()) }
}

fun checkCorrectLotto(correctNumbers: List<Number>, lottos: List<Lotto>) {
    for (correctNumber in correctNumbers) {
        lottos.forEach { it.checkCorrect(correctNumber) }
    }
}
