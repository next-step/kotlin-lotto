package lotto.view

import lotto.domain.LottoResult
import lotto.domain.LottoTickets
import lotto.domain.Rank
import lotto.domain.WinningNumber
import lotto.provider.ResultProvider

class ResultView(private val resultProvider: ResultProvider = ResultProvider) {

    fun getResult(
        lottoTickets: LottoTickets,
        winningNumber: WinningNumber,
        ticketPrice: Int,
        remainder: Int
    ): LottoResult = resultProvider.provideLottoResult(lottoTickets, winningNumber, ticketPrice, remainder)

    fun printResult(lottoResult: LottoResult) {

        var profit: Long = 0

        Rank.values().forEach { rank ->
            println("${rank.hitCount}개 일치 (${rank.prize}원)- ${lottoResult.rankResult[rank]}개")
            profit += (lottoResult.rankResult[rank] ?: 0) * rank.prize
        }

        val profitRate = String.format("%.2f", profit.toDouble() / lottoResult.netSpent.toDouble()).toDouble()

        println("총 수익은 $profit 입니다.")
        println("총 수익률은 $profitRate 입니다.")
    }
}
