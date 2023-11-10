package lotto

import lotto.lotto.Lotto
import lotto.lotto.LottoPrize
import lotto.lotto.toWinningLotto
import lotto.lotto_auto.LottoAuto
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    val inputAmount = InputView.input()
    val count = InputView.lottoCount(inputAmount)

    val lottoList = (1..count).map { Lotto() }
    OutputView.print(lottoList)

    val lastWeekLottoNumber = InputView.lastWeekInput()
    val bonusBallNumber = InputView.bonusBallInput()
    val winningLotto = lastWeekLottoNumber.toWinningLotto(bonusBallNumber)

    val matchedLottoCountWithBonusBall = LottoAuto.matchedLottoCountWithBonusBall(lottoList, winningLotto)

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
