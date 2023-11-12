package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRank
import lotto.domain.LottoResult

object OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { printLotto(it) }
    }

    fun printResult(lottoResult: LottoResult) {
        println(
            """
            당첨 통계
            ---------
        """.trimIndent()
        )
        printRanks(lottoResult)
        println("총 수익률은 ${lottoResult.calculateProfitRate()}입니다.")
    }

    private fun printLotto(lotto: Lotto) {
        println("[${lotto.lottoNumbers.joinToString(separator = ", ")}]")
    }

    private fun printRanks(lottoResult: LottoResult) {
        LottoRank.values()
            .filter { it != LottoRank.MISS }
            .sortedBy { it.matchCount }
            .forEach { rank ->
                val count = lottoResult.ranks[rank]?.size ?: 0
                println("${rank.matchCount}개 일치 (${rank.prize}원)- ${count}개")
            }
    }
}
