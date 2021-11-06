package lotto

import lotto.domain.BonusNumber
import lotto.domain.LastWeekNumber
import lotto.domain.LotteryPaper
import lotto.domain.LottoResult
import lotto.ui.InputView.readInputForLastWeekBonusNumbers
import lotto.ui.InputView.readInputForLastWeekNumbers
import lotto.ui.InputView.readInputForLottoGameBudget
import lotto.ui.ResultView.printLottoPaper
import lotto.ui.ResultView.printLottoResult
import lotto.ui.ResultView.printNumberOfLottoGames
import lotto.ui.ResultView.printRequestBudget
import lotto.ui.ResultView.printRequestLastWeekBonusNumber
import lotto.ui.ResultView.printRequestLastWeekNumber

fun main() {
    printRequestBudget()
    val budget = readInputForLottoGameBudget()
    val lotteryPaper = LotteryPaper(budget)
    printNumberOfLottoGames(lotteryPaper)
    printLottoPaper(lotteryPaper)

    printRequestLastWeekNumber()
    val lastWeekNumbers = LastWeekNumber(readInputForLastWeekNumbers())
    printRequestLastWeekBonusNumber()
    val inputtedBonusNumber = readInputForLastWeekBonusNumbers()
    val bonusNumber = BonusNumber(inputtedBonusNumber, lastWeekNumbers)
    val lottoResult = LottoResult(lotteryPaper, lastWeekNumbers, bonusNumber)
    printLottoResult(budget, lottoResult)
}
