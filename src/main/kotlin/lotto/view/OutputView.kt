package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRank

object OutputView {
    fun printLottos(lottos: List<Lotto>) {
        for (lotto in lottos) {
            printLotto(lotto)
        }
    }

    private fun printLotto(lotto: Lotto) {
        println(lotto.lottoNumbers.map { it.value })
    }

    fun printLottoRankStatics(lottoRanks: Map<LottoRank, Int>) {
        println("당첨 통계")
        println("-----------")
        lottoRanks.entries
            .filterNot { (rank, _) -> rank == LottoRank.NONE }
            .forEach { (rank, count) ->
                println("${rank.matchingCount}개 일치 (${rank.price}원) - ${count}개")
            }
    }

    fun printProfitRate(profitRate: Double) {
        val result = if (profitRate > 1) {
            "이익"
        } else if (profitRate == 1.0) {
            "동일"
        } else {
            "손해"
        }
        println("총 수익률은 ${profitRate}입니다.(기준이 1이기 때문에 결과적으로 $result 이라는 의미임)")
    }
}
