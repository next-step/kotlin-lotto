package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoStore
import lotto.domain.Money
import lotto.domain.toLottoNumbers
import lotto.view.InputView
import lotto.view.PrintView

fun main() {
    val userMoneyInput = InputView.getUserMoney()
    val userMoney = Money(userMoneyInput)

    var manualLottoCount: Int
    do {
        manualLottoCount = InputView.getLottoCount()
    } while (manualLottoCount > userMoney.getLottoCount())

    val lottoStore = LottoStore(userMoney, manualLottoCount)

    val manualLottoNumbers = InputView.getLottoNumbers(manualLottoCount)

    lottoStore.buyManualLottos(
        manualLottoNumbers.map {
            LottoNumbers.of(it)
        }
    )

    PrintView.printLottoCount(manualLottoCount, lottoStore.autoLottoCount)
    PrintView.printBoughtLottoList(lottoStore.boughtMoney)

    val answer = InputView.getLottoNumbers(InputView.LOTTO_ANSWER_INPUT_MESSAGE)
    val bonusBall = InputView.getBonusBall()
    val winnerInfos = lottoStore.getLottoResult(answer.toLottoNumbers(), LottoNumber(bonusBall))
    PrintView.printWinnerInfos(winnerInfos)

    val yieldRatio = lottoStore.totalYieldRatio
    PrintView.printYield(yieldRatio)
}
