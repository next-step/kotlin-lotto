package lotto.view

import lotto.model.Lotto
import lotto.model.LottoRank
import lotto.model.LottoResult

class OutputView {
    fun showBuyingHistory(manualLottoCount: Int, lottoList: List<Lotto>) {
        println("수동으로 ${manualLottoCount}장, 자동으로 ${lottoList.size - manualLottoCount}개를 구매했습니다.")
        lottoList.forEach {
            println(showLotto(it))
        }
    }

    private fun showLotto(lotto: Lotto) = lotto.toList().joinToString(separator = ", ", prefix = "[", postfix = "]")

    fun showMatchStatistics(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")

        LottoRank.values().forEach { rank ->
            println("${rank.matches}개 일치 (${rank.price}) : ${lottoResult.lottoRankList.count { it?.matches == rank.matches && it.bonusMatches == rank.bonusMatches }} 개")
        }

        println("총 수익률은 ${lottoResult.profitRate} 입니다.")
    }
}
