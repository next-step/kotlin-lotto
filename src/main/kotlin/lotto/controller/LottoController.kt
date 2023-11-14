package lotto.controller

import lotto.domain.LottoRoiCalculator
import lotto.domain.LottoShop
import lotto.domain.LottoWinning
import lotto.dto.BonusNumberDto
import lotto.dto.JackpotDto
import lotto.dto.LottoDto
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    OutputView.printEnterMoney()
    val money = InputView.inputMoney()

    val lottoShop = LottoShop()
    val lottoBuyCount = lottoShop.countBuyLotto(money)
    OutputView.printLottoCount(lottoBuyCount.toString())
    val lottoList = lottoShop.buyLotto(lottoBuyCount)
    val lottoDto = lottoList.map { LottoDto(it) }.toList()

    OutputView.printLottoList(lottoDto)

    OutputView.printJackpotNumber()
    val inputNumber = InputView.inputJackpotNumber()
    OutputView.printBonusNumber()
    val bonusNumber = BonusNumberDto(InputView.inputBonusNumber()).lottoNumber

    val jackpotNumbers = lottoShop.generateJackpotNumbers(inputNumber)
    val lottoWinning = LottoWinning(jackpotNumbers, bonusNumber)

    OutputView.printLottoStatistics()
    OutputView.printLine()
    val findJackpot = lottoWinning.checkLottoWinning(lottoList)

    val totalIncome = LottoRoiCalculator.calculateTotalIncome(findJackpot)
    val roi = LottoRoiCalculator.calculateROI(totalIncome, money)

    val jackPotDto: List<JackpotDto> = findJackpot.map { JackpotDto(it) }.toList()
    OutputView.printResult(jackPotDto)
    OutputView.printROI(roi)
}
