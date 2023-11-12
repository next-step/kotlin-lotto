package lotto.controller

import lotto.domain.LottoRoiCalculator
import lotto.domain.LottoShop
import lotto.domain.LottoWinning
import lotto.dto.JackpotDto
import lotto.dto.LottoDto
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    OutputView.printEnterMoney()
    val money = InputView.inputMoney()

    val lottoShop = LottoShop()
    val lottoBuyCount = lottoShop.getLottoBuyCount(money)
    OutputView.printLottoCount(lottoBuyCount.toString())
    val lottoList = lottoShop.buyLotto(lottoBuyCount)
    val lottoDto = lottoList.map { LottoDto(it) }.toList()

    OutputView.printLottoList(lottoDto)

    OutputView.printJackpotNumber()
    val inputNumber = InputView.inputJackpotNumber()
    OutputView.printBonusNumber()
    val bonusNumber = InputView.inputBonusNumber()

    val jackpotNumbers = lottoShop.getJackpotNumbers(inputNumber)
    val lottoWinning = LottoWinning(jackpotNumbers)

    OutputView.printLottoStatistics()
    OutputView.printLine()
    val findJackpot = lottoWinning.checkLottoWinning(lottoList, bonusNumber)

    val totalIncome = LottoRoiCalculator.getTotalIncome(findJackpot)
    val roi = LottoRoiCalculator.calculateROI(totalIncome, money)

    val jackPotDto: List<JackpotDto> = findJackpot.map { JackpotDto(it) }.toList()
    OutputView.printResult(jackPotDto)
    OutputView.printROI(roi)
}
