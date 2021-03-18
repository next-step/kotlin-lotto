package lotto.view

import lotto.domain.LottoGame
import lotto.domain.LottoNumbers
import lotto.domain.Ranking

object Output {

    fun printPickNumber(manualPickCount: Int, lottoNumbers: List<LottoNumbers>) {
        println("\n수동으로 ${manualPickCount}장, 자동으로 ${lottoNumbers.size - manualPickCount}개를 구매했습니다.")
        lottoNumbers.map { it.joinToString(prefix = "[", postfix = "]") }
            .forEach { println(it) }
    }

    fun printLottoResult(lottoResult: LottoGame.Result) {
        println(
            """
            당첨 통계
            ---------
            """.trimIndent()
        )
        val entries = lottoResult.entries()
        enumValues<Ranking.Rank>()
            .filterNot { it == Ranking.Rank.MISS }
            .forEach { rank ->
                println(rankMessage(rank, entries[rank] ?: 0))
            }

        println("총 수익률은 ${lottoResult.profit()}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    private fun rankMessage(rank: Ranking.Rank, count: Int): String {
        var resultMessage = "${rank.match.count}개 일치"
        if (rank == Ranking.Rank.SECOND) {
            resultMessage += ", 보너스 볼 일치"
        }
        return resultMessage + " (${rank.amount}원)- ${count}개"
    }
}
