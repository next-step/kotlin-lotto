package lotto

import lotto.domain.Lotto
import lotto.domain.Number
import lotto.domain.Rank
import lotto.domain.Result
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
    val rank = Rank()
    val money = InputView.inputMoney()
    val amount = money / 1000
    val lottos = makeLottos(amount)
    ResultView.viewLottos(amount, lottos)
    val correctNumbers = InputView.inputCorrectNumbers()
    checkCorrectLotto(correctNumbers, lottos, rank)
    val result = Result(rank.ranks)
    ResultView.viewResult(result.getRanks(), result.getRateOfReturn(money))
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

fun checkCorrectLotto(correctNumbers: List<Number>, lottos: List<Lotto>, rank: Rank) {
    lottos.forEach {
        val ranking = it.getRank(correctNumbers)
        rank.joinRank(ranking)
    }
}
