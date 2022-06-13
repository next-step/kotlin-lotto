package lotto.view

import lotto.domain.LottoGame
import lotto.domain.Rank

object LottoGameView {

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
        println(
            """
            |$WINNING_STAT_MESSAGE
            |${(3..6).joinToString("\n") { prizeMessageTemplate(lottoGame.rank(it), Rank.of(it)) }}
            |${createProfitMessage(lottoGame.profit)}
            """.trimMargin()
        )
    }

    private const val PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
    private const val BUY_AMOUNT_MESSAGE = "개를 구매했습니다."
    private const val LAST_WINNING_NUMBER_MESSAGE = "지난 주 당첩 번호를 입력해 주세요."
    private const val WINNING_STAT_MESSAGE = "당첨 통계\n---------"
    private val prizeMessageTemplate = { n:Int, rank: Rank -> "${rank.matched}개 일치 (${rank.prize.toInt()}원) - ${n}개"}
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
