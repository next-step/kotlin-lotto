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
            Lotto(
                InputView.inputManualLottoNumbers()
                    .map(::LottoNumber)
                    .toSet(),
            )
        }

    val lottoTicket = lottoGame.generateLottoTicket(amount.getPurchaseLottoCount(), manualLottos)
    OutputView.printLottoCount(amount.getPurchaseLottoCount() - manualLottoCount, manualLottoCount)
    lottoTicket.lottoTicket.forEach {
        OutputView.printLotto(it.lotto)
    }

    val winningResult =
        lottoGame.getWinningResult(
            lottoTicket,
            InputView.inputWinningNumbers().map { LottoNumber(it) }.toList(),
            amount.getPurchaseAmount(),
        )
    OutputView.printResult(winningResult)
}
