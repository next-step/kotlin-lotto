import domain.Amount
import domain.Lotto
import domain.LottoNumber
import presentation.InputView
import presentation.OutputView
import service.LottoGame

val lottoGame = LottoGame()

fun main() {
    val amount = Amount(InputView.inputPurchaseAmount())

    val manualLottoCount = InputView.inputManualLottoCount(amount.getPurchaseLottoCount())
    OutputView.printManualLottoInput()
    val manualLottos: List<Lotto> =
        List(manualLottoCount) {
            Lotto(InputView.inputManualLottoNumbers().map(::LottoNumber).toSet())
        }

    val lottoTicket = lottoGame.generateLottoTicket(amount.getPurchaseLottoCount(), manualLottos)
    OutputView.printLottoCount(amount.getPurchaseLottoCount() - manualLottoCount, manualLottoCount)
    lottoTicket.lottoTicket.forEach { OutputView.printLotto(it.lotto) }

    val winningNumbers = Lotto(InputView.inputWinningNumbers().map { LottoNumber(it) }.toSet())
    val bonusBall = LottoNumber(InputView.inputBonusBallNumber())
    val winningResult = lottoGame.getWinningResult(lottoTicket, winningNumbers, bonusBall, amount.getPurchaseAmount())
    OutputView.printResult(winningResult)
}
