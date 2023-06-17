package lotto.view

import lotto.dto.LottoResult
import lotto.entity.Lotto
import lotto.entity.Rank
import kotlin.math.round

object OutputView {
    fun printPurchaseQuantity(quantity: Int) {
        println("${quantity}개를 구매했습니다.")
    }

    fun printLotto(lottoTickets: List<Lotto>) {
        lottoTickets.forEach {
            println(it.numbers)
        }
    }

    fun printResult(lottoResult: LottoResult) {
        val rankToInt = lottoResult.rankToHowManyWins
        val rateOfReturn = round((lottoResult.rateOfReturn * 100) / 100)
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${Rank.Fourth.prize}원) - ${rankToInt[Rank.Fourth] ?: 0}")
        println("4개 일치 (${Rank.Third.prize}원) - ${rankToInt[Rank.Third] ?: 0}")
        println("5개 일치 (${Rank.Second.prize}원) - ${rankToInt[Rank.Second] ?: 0}")
        println("6개 일치 (${Rank.First.prize}원) - ${rankToInt[Rank.First] ?: 0}")
        println("총 수익률은 ${rateOfReturn}입니다.")
    }
}
