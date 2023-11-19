package lotto.controller

import lotto.domain.LottoRoiCalculator
import lotto.domain.LottoShop
import lotto.domain.LottoWinning
import lotto.domain.Lottos
import lotto.dto.BonusNumberDto
import lotto.dto.JackpotDto
import lotto.dto.LottoDto
import lotto.dto.LottoPurchaseInfoDto
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    OutputView.printEnterMoney()
    val money = InputView.inputMoney()
    OutputView.printManualLottoBuyCount()
    val manualLottoBuyCount = InputView.inputManualLottoBuyCount()
    OutputView.printManualLottoNumbers()
    val lottoShop = LottoShop()
    val manualLottos = Lottos(
        List(manualLottoBuyCount) { lottoShop.generateLottoNumbers(InputView.inputManualLottoNumbers()) }
    )

    val lottoPurchaseInfo = lottoShop.countBuyLotto(money, manualLottoBuyCount)
    val lottoPurchaseInfoDto = LottoPurchaseInfoDto(lottoPurchaseInfo)
    OutputView.printLottoCount(lottoPurchaseInfoDto)

    val totalLottos = lottoShop.buyLotto(lottoPurchaseInfoDto.autoLottoCount, manualLottos)
    val lottoDto = totalLottos.lottos.map { LottoDto(it) }.toList()

    OutputView.printLottoList(lottoDto)
    OutputView.printJackpotNumber()
    val inputNumber = InputView.inputJackpotNumber()
    OutputView.printBonusNumber()
    val bonusNumber = BonusNumberDto(InputView.inputBonusNumber()).bonusNumber

    val jackpotNumbers = lottoShop.generateLottoNumbers(inputNumber)
    val lottoWinning = LottoWinning(jackpotNumbers, bonusNumber)

    OutputView.printLottoStatistics()
    OutputView.printLine()
    val findJackpot = lottoWinning.checkLottoWinning(totalLottos)

    val totalIncome = LottoRoiCalculator.calculateTotalIncome(findJackpot)
    val roi = LottoRoiCalculator.calculateROI(totalIncome, money)

    val jackPotDto: List<JackpotDto> = findJackpot.map { JackpotDto(it) }.toList()
    OutputView.printResult(jackPotDto)
    OutputView.printROI(roi)
}
