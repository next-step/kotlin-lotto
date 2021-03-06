package lotto

import lotto.model.Coincidence
import lotto.model.Lotto
import lotto.model.Lottos
import lotto.model.Money

fun main() {
    println("구입금액을 입력해 주세요.")
    var budget = readLine()

    while (budget.isNullOrBlank()) {
        println("구입금액을 입력해 주세요.")
        budget = readLine()
    }
    println()

    val money = Money(budget)
    val lottoCount = money.getAvailableLottoCount()
    println("${lottoCount}개를 구매했습니다.")

    val myLottos = Lottos(lottoCount)
    myLottos.lottos.forEach { println(it.lottoNumbers.toString()) }

    println()
    println("지난 주 당첨 번호를 입력해 주세요.")
    var winningNumbers = readLine()
    while (budget.isNullOrBlank()) {
        println("지난 주 당첨 번호를 입력해 주세요.")
        winningNumbers = readLine()
    }

    val winningLotto = Lotto(winningNumbers!!)

    println("당첨 통계")
    println("==============")

    Coincidence.values().forEach {
        val count = myLottos.check(winningLotto.lottoNumbers.map { it.number }, it.coincidenceCount)
        println("${it.coincidenceCount}개 일치 (${it.prizeMoney}원) - ${count}개 ")
    }

    val earningRate = myLottos.getEarningRate(winningLotto.lottoNumbers.map { it.number })
    println("총 수익률은 $earningRate")
}
