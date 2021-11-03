package lotto.ui

import lotto.domain.LotteryPaper
import lotto.domain.LottoGame

object ResultView {
    private const val REQUEST_BUDGET = "구입금액을 입력해 주세요."
    private const val NUMBER_OF_LOTTO_GAMES_SUFFIX = "개를 구매했습니다."

    fun printRequestBudget() = println(REQUEST_BUDGET)

    fun printNumberOfLottoGames(lotteryPaper: LotteryPaper) =
        println("${lotteryPaper.getNumberOfGames()}$NUMBER_OF_LOTTO_GAMES_SUFFIX")

    fun printLottoPaper(lotteryPaper: LotteryPaper) = lotteryPaper.getLottoGames().forEach { printLottoGame(it) }
    private fun printLottoGame(lottoGame: LottoGame) = println(lottoGame.getNumbers().joinToString(", ", "[", "]"))
}
