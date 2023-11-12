package lotto

import lotto.lotto.LottoGenerator
import lotto.lotto.LottoPrize
import lotto.lotto.LottoType
import lotto.lotto.toWinningLotto
import lotto.lotto_auto.LottoAuto
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    val inputAmount = InputView.inputAmount()
    val inputManualCount = InputView.inputManualCount()
    val totalLottoCount = InputView.calculateTotalLottoCount(inputAmount)
    val autoLottoCount = totalLottoCount - inputManualCount

    OutputView.printRequestEnterManualLottoNumber()
    val manualLottoList = LottoGenerator.createLottoList(inputManualCount, LottoType.MANUAL)
    val autoLottoList = LottoGenerator.createLottoList(autoLottoCount, LottoType.AUTO)

    OutputView.printTotalLottoCount(inputManualCount, autoLottoCount)
    OutputView.printAutoLottoList(autoLottoList)

    val lastWeekLottoNumber = InputView.lastWeekInput()
    val bonusBallNumber = InputView.bonusBallInput()
    val winningLotto = lastWeekLottoNumber.toWinningLotto(bonusBallNumber)

    val matchedLottoCountWithBonusBall =
        LottoAuto.matchedLottoCountWithBonusBall(autoLottoList + manualLottoList, winningLotto)

    val sumOfWonLotto = LottoAuto.sumOfWonLottoList(matchedLottoCountWithBonusBall)

    val resultRate: Float = LottoAuto.earningRate(sumOfWonLotto, inputAmount)

    val matchCountList = LottoAuto.matchCountList(matchedLottoCountWithBonusBall.map {
        LottoPrize.getLottoPrize(
            it.lottoPrize.matchCount,
            it.bonusBallMatched
        )
    })

    val fillDefaultCountMap = LottoPrize.values().associateWith { matchCountList.getOrDefault(it, 0) }

    OutputView.showResult(fillDefaultCountMap, resultRate)
}
