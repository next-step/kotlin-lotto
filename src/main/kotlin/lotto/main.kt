package lotto

import lotto.domain.LottoGenerator
import lotto.domain.LottoWinChecker
import lotto.domain.money.Won
import lotto.view.inputView.LottoInputView
import lotto.view.outputView.LottoOutputView

fun main() {
    val lottoInputView = LottoInputView()
    val lottoOutputView = LottoOutputView()
    val lottoGenerator = LottoGenerator(lottoPrice = Won(5000))

    val moneyToPay = lottoInputView.receiveMoney()
    val lottos = lottoGenerator.generate(paidPrice = moneyToPay)
    lottoOutputView.printLottoBuyResult(lottos)

    val winningNumbers = lottoInputView.receiveWinningNumbers()
    val prizes = LottoWinChecker(lottos).getPrizes(winningNumbers)

    lottoOutputView.printLottoWinCheckResult(moneyToPay, prizes)
}
