package lotto

import lotto.domain.LottoGenerator
import lotto.view.inputView.LottoInputView
import lotto.view.inputView.ManualLottoInputView
import lotto.view.outputView.LottoOutputView

fun main() {
    val lottoInputView = LottoInputView()
    val lottoOutputView = LottoOutputView()

    val moneyToPay = lottoInputView.receiveMoney()
    val (manualLottos, balance) = ManualLottoInputView(moneyToPay).receiveManualLottos()

    val lottoGenerator = LottoGenerator()
    val lottos = lottoGenerator.generate(paidPrice = balance)

    lottoOutputView.printLottoBuyResult(lottos, manualLottos)

    val winningLotto = lottoInputView.receiveWinningLotto()
    val prizes = winningLotto.getPrizes(lottos + manualLottos)

    lottoOutputView.printLottoWinCheckResult(moneyToPay, prizes)
}
