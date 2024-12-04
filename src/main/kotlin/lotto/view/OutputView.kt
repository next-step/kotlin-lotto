package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRank

class OutputView {
    companion object {
        private const val PURCHASE_RESULT_MESSAGE = "개를 구매했습니다."
        private const val LOTTO_STATISTICS_TITLE = "당첨통계"
        private const val LOTTO_STATISTICS_SEPARATOR = "---------"
        private const val MATCH_COUNT_MESSAGE = "%s개 일치 (%s원) %s개"
        private const val EARNING_RATIO_MESSAGE = "총 수익률은 %s 입니다. (기준이 1이기 때문에 결과적으로 %s라는 의미임)"

        fun printPurchaseResult(purchasedLottos: List<Lotto>) {
            println("${purchasedLottos.size} $PURCHASE_RESULT_MESSAGE")
            printLottoNumbers(purchasedLottos)
        }

        private fun printLottoNumbers(purchasedLottos: List<Lotto>) {
            purchasedLottos.forEach {
                println(it.lottoNumbers)
            }
            println()
        }

        fun printLottoResult(
            lottoResult: Map<LottoRank, Int>,
            earningRatio: Double,
            profitStatus: String,
        ) {
            println(LOTTO_STATISTICS_TITLE)
            println(LOTTO_STATISTICS_SEPARATOR)
            lottoResult.forEach { (lottoRank, count) ->
                println(MATCH_COUNT_MESSAGE.format(lottoRank.matchCount, lottoRank.prize, count))
            }
            println(EARNING_RATIO_MESSAGE.format(earningRatio, profitStatus))
        }
    }
}
