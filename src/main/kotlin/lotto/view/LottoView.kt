package lotto.view

import lotto.domain.LottoNumbers
import lotto.domain.LottoProfitRate
import lotto.domain.LottoRankMatchMap
import lotto.domain.Lottos

object LottoView {
    fun drawLottos(lottos: Lottos) {
        lottos.lottos.forEach { drawLottoNumbers(it.numbers) }
    }

    fun drawMatchMap(lottoRankMatchMap: LottoRankMatchMap) {
        println("당첨 통계")
        println("---------")
        lottoRankMatchMap.lottoRankMatchMap.forEach { println("${it.key}등 : ${it.value}개") }
    }

    fun drawProfitRate(lottoProfitRate: LottoProfitRate) {
        val lottoProfitRateDescription = if (lottoProfitRate.profitRate > 1.0) "이득이에요" else "손해에요"
        println("총 수익률은 ${lottoProfitRate.profitRate}입니다. $lottoProfitRateDescription")
    }

    private fun drawLottoNumbers(lottoNumbers: LottoNumbers) {
        val joinToString =
            lottoNumbers.lottoNumbers.map { it.number }.sorted()
                .joinToString(prefix = "[", postfix = "]", separator = ",")
        println(joinToString)
    }
}
