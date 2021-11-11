package lotto

import lotto.domain.LottoGenerator
import lotto.view.inputView.LottoInputView
import lotto.view.outputView.LottoOutputView

fun main() {
    val lottoInputView = LottoInputView()
    val lottoOutputView = LottoOutputView()
    val lottoGenerator = LottoGenerator()

    val moneyToPay = lottoInputView.receiveMoney()
    val lottos = lottoGenerator.generate(paidPrice = moneyToPay)
    lottoOutputView.printLottoBuyResult(lottos)

    val winningLotto = lottoInputView.receiveWinningLotto()
    val prizes = winningLotto.getPrizes(lottos)

    lottoOutputView.printLottoWinCheckResult(moneyToPay, prizes)
}
