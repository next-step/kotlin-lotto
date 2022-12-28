package lotto.views

import lotto.LottoNumbers
import lotto.Rank

object Output {
    fun printBuyAmount(amount: Int) {
        println("$amount 개를 구매했습니다.")
    }

    fun printLottoNumbers(lottoNumbers: List<LottoNumbers>) {
        lottoNumbers.forEach { println(it) }
    }

    fun printLottoResult(ranks: List<Rank>) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${Rank.FOURTH.winningPrice}원) - ${ranks.count { it == Rank.FOURTH }}개")
        println("4개 일치 (${Rank.THIRD.winningPrice}원) - ${ranks.count { it == Rank.THIRD }}개")
        println("5개 일치 (${Rank.SECOND.winningPrice}원) - ${ranks.count { it == Rank.SECOND }}개")
        println("6개 일치 (${Rank.FIRST.winningPrice}원) - ${ranks.count { it == Rank.FIRST }}개")
    }

    fun printEarningRate(earningRate: Double) {
        println("총 수익률은 $earningRate 입니다.")
    }
}
