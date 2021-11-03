package lotto

import lotto.domain.LastWeekNumber
import lotto.domain.LotteryPaper
import lotto.ui.InputView.readInputForLastWeekNumbers
import lotto.ui.InputView.readInputForLottoGameBudget
import lotto.ui.ResultView.printLottoPaper
import lotto.ui.ResultView.printNumberOfLottoGames
import lotto.ui.ResultView.printRequestBudget
import lotto.ui.ResultView.printRequestLastWeekNumber

fun main() {
    printRequestBudget()
    val budget = readInputForLottoGameBudget()

    val lotteryPaper = LotteryPaper(budget)

    printNumberOfLottoGames(lotteryPaper)
    printLottoPaper(lotteryPaper)

    printRequestLastWeekNumber()
    val lastWeekNumbers = LastWeekNumber(readInputForLastWeekNumbers())
}
