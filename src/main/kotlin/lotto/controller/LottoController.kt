package lotto.controller

import lotto.domain.LottoGenerator
import lotto.domain.LottoRoiCalculator
import lotto.domain.LottoShop
import lotto.domain.LottoWinning
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    OutputView.printEnterMoney()
    val money = InputView.inputMoney()

    val lottoShop = LottoShop()
    val lottoTryCount = lottoShop.getLottoCount(money)
    OutputView.printLottoCount(lottoTryCount.toString())

    val lottoGenerator = LottoGenerator()
    val lottoList = lottoGenerator.getLotto(lottoTryCount)
    OutputView.printLottoList(lottoList)

    OutputView.printJackpotNumber()
    val inputNumber = InputView.inputJackpotNumber()
    val lottoWinning = LottoWinning()
    val jackpotNumbers = lottoWinning.splitLottoNumber(inputNumber)

    OutputView.printLottoStatistics()
    OutputView.printLine()
    val findJackpotLotto = lottoWinning.checkLottoWinning(jackpotNumbers, lottoList)

    val totalIncome = LottoRoiCalculator.getTotalIncome(findJackpotLotto)
    val roi = LottoRoiCalculator.calculateROI(totalIncome, money)
    OutputView.printResult(findJackpotLotto)
    OutputView.printROI(roi)
}
