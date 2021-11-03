package lotto

import lotto.domain.LotteryPaper
import lotto.ui.InputView.readInputForLottoGameBudget
import lotto.ui.ResultView.printLottoPaper
import lotto.ui.ResultView.printNumberOfLottoGames
import lotto.ui.ResultView.printRequestBudget

fun main() {
    printRequestBudget()
    val budget = readInputForLottoGameBudget()

    val lotteryPaper = LotteryPaper(budget)

    printNumberOfLottoGames(lotteryPaper)
    printLottoPaper(lotteryPaper)
}
