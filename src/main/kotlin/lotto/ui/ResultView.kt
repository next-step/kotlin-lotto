package lotto.ui

import lotto.domain.LotteryPaper
import lotto.domain.LotteryWinningTypes
import lotto.domain.LottoGame
import lotto.domain.LottoGameResult
import lotto.domain.LottoResult

object ResultView {
    private const val REQUEST_BUDGET = "구입금액을 입력해 주세요."
    private const val NUMBER_OF_LOTTO_GAMES_SUFFIX = "개를 구매했습니다."
    private const val REQUEST_BUDGET_LAST_WEEK_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    private const val REQUEST_BUDGET_LAST_WEEK_BONUS_NUMBER = "지난 주 보너스 번호를 입력해 주세요."
    private const val WINNING_RESULT_FORMAT = "%s개 일치 (%s원)- %s개"
    private const val WINNING_RATIO = "총 수익률은 %.2f입니다."
    private const val GAME_RESULT_ANNOUNCE = "당첨 통계"
    private const val GAME_RESULT_DIVIDER = "----------"

    fun printRequestBudget() = println(REQUEST_BUDGET)

    fun printNumberOfLottoGames(lotteryPaper: LotteryPaper) =
        println("${lotteryPaper.getNumberOfGames()}$NUMBER_OF_LOTTO_GAMES_SUFFIX")

    fun printLottoPaper(lotteryPaper: LotteryPaper) = lotteryPaper.getLottoGames().forEach { printLottoGame(it) }

    fun printRequestLastWeekNumber() {
        println(REQUEST_BUDGET_LAST_WEEK_NUMBER)
    }

    fun printRequestLastWeekBonusNumber() {
        println(REQUEST_BUDGET_LAST_WEEK_BONUS_NUMBER)
    }

    fun printLottoResult(budget: Int, lottoResult: LottoResult) {
        println(GAME_RESULT_ANNOUNCE)
        println(GAME_RESULT_DIVIDER)

        val lottoResultOnlyWinning = lottoResult.getLottoResultMapOnlyWinning()
        printWinnings(lottoResultOnlyWinning)
        printWinningRatio(budget, getFullWinnings(lottoResultOnlyWinning))
    }

    private fun printWinnings(lottoResultOnlyWinning: Map<LotteryWinningTypes, Int>) =
        lottoResultOnlyWinning
            .forEach { printLottoGameResult(it.key.result, it.key.winnings, it.value) }

    private fun getFullWinnings(lottoResultOnlyWinning: Map<LotteryWinningTypes, Int>) =
        lottoResultOnlyWinning
            .map { it.key.winnings * it.value }
            .sum()

    private fun printLottoGameResult(lottoResult: LottoGameResult, winning: Int, numberOfGames: Int) =
        printFormatWithResult(WINNING_RESULT_FORMAT, lottoResult.numberOfHit, winning, numberOfGames)


    private fun printFormatWithResult(format: String, numberOfHit: Int, winning: Int, numberOfGames: Int) =
        println(format.format(numberOfHit, winning, numberOfGames))

    private fun printWinningRatio(budget: Int, fullWinnings: Int) =
        println(WINNING_RATIO.format(fullWinnings / budget.toFloat()))

    private fun printLottoGame(lottoGame: LottoGame) = println(lottoGame.numbers.joinToString(", ", "[", "]"))
}
