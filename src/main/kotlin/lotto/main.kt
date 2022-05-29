package lotto

import lotto.domain.KoreanLottoNumberMaker
import lotto.domain.LottoNumber
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

    val lottoMaker = KoreanLottoNumberMaker()
    val manualLottoNumbers = InputView.getLottoNumbers(manualLottoCount)
    lottoMaker.buyManualLotto(manualLottoNumbers)

    val lottoStore = LottoStore(userMoney, manualLottoCount, lottoMaker)

    PrintView.printLottoCount(manualLottoCount, lottoStore.autoLottoCount)
    PrintView.printBoughtLottoList(lottoStore.boughtMoney)

    val answer = InputView.getLottoNumbers(InputView.LOTTO_ANSWER_INPUT_MESSAGE)
    val bonusBall = InputView.getBonusBall()
    val winnerInfos = lottoStore.getLottoResult(answer.toLottoNumbers(), LottoNumber(bonusBall))
    PrintView.printWinnerInfos(winnerInfos)

    val yieldRatio = lottoStore.totalYieldRatio
    PrintView.printYield(yieldRatio)
}
