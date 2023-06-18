import lotto.domain.LottoServiceRound
import lotto.domain.Money.Companion.toMoney
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

fun main() = lotto()

fun lotto() {
    val lottoServiceRound = LottoServiceRound()
    val lottoInputView = LottoInputView()
    val lottoOutputView = LottoOutputView()

    val payment = lottoInputView.inputLottoBuy()
    lottoServiceRound.buyLottos(payment.toLong().toMoney()).also {
        lottoOutputView.currentLottos(it)
    }

    val winningLottoNumbers = lottoInputView.inputWinningLotto()
    val lottoRoundStatistics = lottoServiceRound.lotteryDraw(winningLottoNumbers)
    lottoOutputView.result(lottoServiceRound.allPayment().value, lottoRoundStatistics)
}
