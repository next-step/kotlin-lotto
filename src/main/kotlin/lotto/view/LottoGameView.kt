package lotto.view

import lotto.domain.LottoGame

class LottoGameView {

    companion object {

        fun printPurchaseAmountInput() {
            println(PURCHASE_AMOUNT_MESSAGE)
        }

        fun printBuyAmount(n: Int) {
            println(n.toString() + BUY_AMOUNT_MESSAGE)
        }

        fun printLastWinningNumbers() {
            println(LAST_WINNING_NUMBER_MESSAGE)
        }

        fun printWinningStats(lottoGame: LottoGame) {
            println(WINNING_STAT_MESSAGE)
            println(create4thMessage(lottoGame.match(3)))
            println(create3rdMessage(lottoGame.match(4)))
            println(create2ndMessage(lottoGame.match(5)))
            println(create1stMessage(lottoGame.match(6)))
            println(createProfitMessage(lottoGame.profit))
        }

        private const val PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        private const val BUY_AMOUNT_MESSAGE = "개를 구매했습니다."
        private const val LAST_WINNING_NUMBER_MESSAGE = "지난 주 당첩 번호를 입력해 주세요."
        private const val WINNING_STAT_MESSAGE = "당첨 통계\n---------"
        private val create4thMessage = { n: Int -> "3개 일치 (5000원)- ${n}개" }
        private val create3rdMessage = { n: Int -> "4개 일치 (50000원)- ${n}개" }
        private val create2ndMessage = { n: Int -> "5개 일치 (1500000원)- ${n}개" }
        private val create1stMessage = { n: Int -> "6개 일치 (2000000000원)- ${n}개" }
        private val createProfitMessage = { profit: Double ->
            "총 수익률은 ${profit}입니다." + getProfitResultMessage(profit)
        }

        private fun getProfitResultMessage(profit: Double): String {
            return if (profit > 1.0) {
                "(기준이 1이기 때문에 결과적으로 이익이라는 의미임)"
            } else if (profit < 1.0) {
                "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
            } else {
                "(기준이 1이기 때문에 결과적으로 본전이라는 의미임)"
            }
        }
    }
}
