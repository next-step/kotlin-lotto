package lotto

import lotto.domain.*
import lotto.view.InputView
import lotto.view.PrintView

fun main() {
    val lottoStore = makeLottoStore()

    getLottoAnswerMeta(lottoStore)

    printLottoResultInfo(lottoStore)
}

fun makeLottoStore(): LottoStore {
    val userMoneyInput = InputView.getUserMoney()
    val userMoney = Money(userMoneyInput)

    var manualLottoCount: Int
    do {
        manualLottoCount = InputView.getLottoCount()
    } while (manualLottoCount > userMoney.getLottoCount())

    val lottoMaker = KoreanLottoNumberMaker()
    val manualLottoNumbers = InputView.getLottoNumbers(manualLottoCount)
    lottoMaker.buyManualLotto(manualLottoNumbers)

    return LottoStore(userMoney, manualLottoCount, lottoMaker).apply {
        PrintView.printLottoCount(manualLottoCount, autoLottoCount)
        PrintView.printBoughtLottoList(boughtMoney)
    }
}

fun getLottoAnswerMeta(lottoStore: LottoStore) {
    val answer = InputView.getLottoNumbers(InputView.LOTTO_ANSWER_INPUT_MESSAGE)
    val bonusBall = InputView.getBonusBall()
    val winnerInfos = lottoStore.getLottoResult(answer.toLottoNumbers(), LottoNumber(bonusBall))
    PrintView.printWinnerInfos(winnerInfos)
}

fun printLottoResultInfo(lottoStore: LottoStore) {
    val yieldRatio = lottoStore.totalYieldRatio
    PrintView.printYield(yieldRatio)
}
