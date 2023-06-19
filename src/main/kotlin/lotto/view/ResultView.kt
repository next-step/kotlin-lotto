package lotto.view

import lotto.domain.LottoRank
import lotto.domain.Lottos
import lotto.dto.ResultDTO

object ResultView {

    fun printLottos(lottos: Lottos) {
        println("${lottos.list.size}개를 구매했습니다.")
        lottos.list.forEach {
            println(it.numbers)
        }
        println()
    }

    fun printStatistics(result: List<ResultDTO>, lottoProfitRatio: Double) {
        println("당첨 통계")
        println("---------")
        LottoRank.values().forEach {
            val lottoResult = result.firstOrNull { result -> result.lottoRank == it }
            val bonusString = if (it == LottoRank.FIVE_WITH_BONUS) ", 보너스 볼 일치" else ""
            println("${it.num}개 일치$bonusString (${it.price})- ${lottoResult?.matchNum ?: 0}개")
        }
        println("총 수익률은 ${lottoProfitRatio}입니다.")
    }
}
