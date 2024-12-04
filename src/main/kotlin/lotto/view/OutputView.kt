package lotto.view

import lotto.domain.Lotto

class OutputView {
    companion object {
        private const val PURCHASE_RESULT_MESSAGE = "개를 구매했습니다."
        private const val RANK_FIRST_MATCH_COUNT_MESSAGE = "6개 일치 (2000000000원)"
        private const val RANK_THIRD_MATCH_COUNT_MESSAGE = "5개 일치 (1500000원)"
        private const val RANK_FOURTH_MATCH_COUNT_MESSAGE = "4개 일치 (50000원)"
        private const val RANK_FIFTH_MATCH_COUNT_MESSAGE = "3개 일치 (5000원)"
        private const val LOTTO_STATISTICS_TITLE = "당첨통계"
        private const val LOTTO_STATISTICS_SEPARATOR = "---------"
        private const val EARNING_RATIO_MESSAGE = "총 수익률은 %s 입니다. (기준이 1이기 때문에 결과적으로 %s라는 의미임)"
        private const val EARNING_RATIO_THRESHOLD = 1.0
        private const val PROFIT_MESSAGE = "이익"
        private const val BREAK_EVEN_MESSAGE = "본전"
        private const val LOSS_MESSAGE = "손해"

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

        private fun rankWithMatchCount(rank: Int): String =
            when (rank) {
                1 -> RANK_FIRST_MATCH_COUNT_MESSAGE
                3 -> RANK_THIRD_MATCH_COUNT_MESSAGE
                4 -> RANK_FOURTH_MATCH_COUNT_MESSAGE
                5 -> RANK_FIFTH_MATCH_COUNT_MESSAGE
                else -> ""
            }

        private fun getProfitStatus(earningRatio: Double): String =
            when {
                earningRatio > EARNING_RATIO_THRESHOLD -> PROFIT_MESSAGE
                earningRatio == EARNING_RATIO_THRESHOLD -> BREAK_EVEN_MESSAGE
                else -> LOSS_MESSAGE
            }
    }
}
