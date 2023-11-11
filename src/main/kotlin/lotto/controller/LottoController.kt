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
    val lottoWinning = LottoWinning()
    val jackpotNumbers = lottoWinning.splitLottoNumber(inputNumber)

    OutputView.printLottoStatistics()
    OutputView.printLine()
    val findJackpot = lottoWinning.checkLottoWinning(jackpotNumbers, lottoList)

    val totalIncome = LottoRoiCalculator.getTotalIncome(findJackpot)
    val roi = LottoRoiCalculator.calculateROI(totalIncome, money)

    val jackPotDto: List<JackpotDto> = findJackpot.map { JackpotDto(it) }.toList()
    OutputView.printResult(jackPotDto)
    OutputView.printROI(roi)
}
