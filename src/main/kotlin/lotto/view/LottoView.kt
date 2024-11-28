package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoProfitRate
import lotto.domain.LottoRankMatchMap
import lotto.domain.Lottos

object LottoView {
    fun drawLottos(lottos: Lottos) {
        lottos.lottos.forEach { drawLotto(it) }
    }

    fun drawMatchMap(lottoRankMatchMap: LottoRankMatchMap) {
        println("당첨 통계")
        println("---------")
        lottoRankMatchMap.lottoRankMatchMap.forEach { println("${it.key}등 : ${it.value}개") }
    }

    fun drawProfitRate(lottoProfitRate: LottoProfitRate) {
        println(
            "총 수익률은 ${lottoProfitRate.profitRate}입니다. " +
                lottoProfitRate.getProfitRateDescription(),
        )
    }

    private fun drawLotto(lotto: Lotto) {
        println(lotto.numbers.asJoinString())
    }
}
