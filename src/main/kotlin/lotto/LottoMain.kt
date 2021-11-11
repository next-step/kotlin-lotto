package lotto

import lotto.domain.BonusNumber
import lotto.domain.LastWeekNumber
import lotto.domain.LotteryPaper
import lotto.domain.LottoNumberSelectPaper
import lotto.domain.LottoResult
import lotto.domain.NumberOfManualSelectGames
import lotto.ui.InputView.readInputForLastWeekBonusNumbers
import lotto.ui.InputView.readInputForLastWeekNumbers
import lotto.ui.InputView.readInputForLottoGameBudget
import lotto.ui.InputView.readInputForNumberOfManualSelectGame
import lotto.ui.InputView.readInputNumbersForManualSelectGame
import lotto.ui.ResultView.printLottoBuyResult
import lotto.ui.ResultView.printLottoResult
import lotto.ui.ResultView.printRequestBudget
import lotto.ui.ResultView.printRequestLastWeekBonusNumber
import lotto.ui.ResultView.printRequestLastWeekNumber
import lotto.ui.ResultView.printRequestManualSelectGameNumbers
import lotto.ui.ResultView.printRequestNumberOfManualSelectGames

fun main() {
    printRequestBudget()
    val budget = readInputForLottoGameBudget()
    printRequestNumberOfManualSelectGames()
    val numberOfManualSelectGame = NumberOfManualSelectGames(readInputForNumberOfManualSelectGame())
    val lottoNumberSelectPaper = LottoNumberSelectPaper(budget, numberOfManualSelectGame)

    printRequestManualSelectGameNumbers()
    makeManualGames(lottoNumberSelectPaper)

    val lotteryPaper = LotteryPaper(lottoNumberSelectPaper)
    printLottoBuyResult(lotteryPaper)

    checkLotteryResult(lotteryPaper)
}

fun makeManualGames(lottoNumberSelectPaper: LottoNumberSelectPaper) {
    repeat(lottoNumberSelectPaper.numberOfManualSelectGames.numberOfGames) {
        val manualSelectLottoGame = readInputNumbersForManualSelectGame()
        lottoNumberSelectPaper.addManualSelectGame(manualSelectLottoGame)
    }
}

fun checkLotteryResult(lotteryPaper: LotteryPaper) {
    printRequestLastWeekNumber()
    val lastWeekNumbers = LastWeekNumber(readInputForLastWeekNumbers())

    printRequestLastWeekBonusNumber()
    val bonusNumber = BonusNumber(readInputForLastWeekBonusNumbers(), lastWeekNumbers)

    val lottoResult = LottoResult(lotteryPaper, lastWeekNumbers, bonusNumber)
    printLottoResult(lotteryPaper.getLottoBudget(), lottoResult)
}
