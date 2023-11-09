package lotto.controller

import lotto.domain.LottoGenerator
import lotto.domain.LottoResult
import lotto.domain.LottoRoiCalculator
import lotto.domain.LottoShop
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    OutputView.printEnterMoney()
    val money = InputView.inputMoney()

    val lottoShop = LottoShop()
    val lottoTryCount = lottoShop.getLottoCount(money)
    OutputView.printLottoCount(lottoTryCount.toString())

    val lottoGenerator = LottoGenerator()
    val lotto = lottoGenerator.getLotto(lottoTryCount)
    OutputView.printLottoList(lotto)

    OutputView.printJackpotNumber()
    val inputNumber = InputView.inputJackpotNumber()
    val lottoResult = LottoResult()
    val jackpotNumbers = lottoResult.splitLottoNumber(inputNumber)

    OutputView.printLottoStatistics()
    OutputView.printLine()
    val findJackpotLotto = lottoResult.findJackpotLotto(jackpotNumbers, lotto)

    val totalIncome = LottoRoiCalculator.getTotalIncome(findJackpotLotto)
    val roi = LottoRoiCalculator.calculateROI(totalIncome, money)
    OutputView.printResult(findJackpotLotto)
    OutputView.printROI(roi)
}
