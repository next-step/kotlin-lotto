package lotto.view

import lotto.model.Lotto
import lotto.model.LottoRank
import lotto.model.LottoResult

class OutputView {
    fun showBuyingHistory(lottoList: List<Lotto>) {
        println("${lottoList.size}개를 구매했습니다.")
        lottoList.forEach {
            println(it)
        }
    }

    fun showMatchStatistics(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")

        LottoRank.values().forEach { rank ->
            println("${rank.matches}개 일치 (${rank.price}) : ${lottoResult.lottoRankList.count { it?.matches == rank.matches }} 개")
        }

        println("총 수익률은 ${lottoResult.profitRate} 입니다.")
    }
}
