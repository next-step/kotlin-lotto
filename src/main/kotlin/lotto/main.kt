package lotto

import lotto.domain.KoreanLottoNumberMaker
import lotto.domain.LottoNumber
import lotto.domain.LottoStore
import lotto.domain.Money
import lotto.domain.toLottoNumbers
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

    val autoLottoCount = userMoney.getLottoCount() - manualLottoCount
    val autoLottoNumbers = List(autoLottoCount) { lottoMaker.buyAutoLotto() }

    return LottoStore(userMoney, lottoMaker.manualLotto, autoLottoNumbers).apply {
        PrintView.printLottoCount(manualLottoCount, autoLottoCount)
        PrintView.printBoughtLottoList(boughtLottos)
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
