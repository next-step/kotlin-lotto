package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRankMatchMap
import lotto.domain.LottoResult

object LottoView {
    fun drawLottos(lottoResult: LottoResult) {
        lottoResult.lottos.lottos.forEach { drawLotto(it) }
    }

    fun drawMatchMap(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")
        drawMatchMap(lottoResult.lottoOutcome.lottoRankMatchMap)
    }

    fun drawProfitRate(lottoResult: LottoResult) {
        println(
            "총 수익률은 ${lottoResult.lottoOutcome.lottoProfitRate.profitRate}입니다. " +
                lottoResult.lottoOutcome.lottoProfitRate.getProfitRateDescription(),
        )
    }

    private fun drawLotto(lotto: Lotto) {
        println(lotto.numbers.asJoinString())
    }

    private fun drawMatchMap(lottoRankMatchMap: LottoRankMatchMap) {
        lottoRankMatchMap.lottoRankMatchMap.forEach { println("${it.key}등 : ${it.value}개") }
    }
}
