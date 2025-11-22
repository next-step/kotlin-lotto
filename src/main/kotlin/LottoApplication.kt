import domain.Amount
import presentation.InputView
import presentation.OutputView
import service.LottoGame

val lottoGame = LottoGame()

fun main() {
    val amount = Amount(InputView.inputPurchaseAmount())
    OutputView.printLottoCount(amount)

    val lottoTicket = lottoGame.generateLottoTicket(amount.getPurchaseLottoCount())
    lottoTicket.lottoTicket.forEach {
        OutputView.printLotto(it.lotto)
    }

    val winningResult =
        lottoGame.getWinningResult(
            lottoTicket,
            InputView.inputWinningNumbers(),
            amount.getPurchaseAmount(),
        )
    OutputView.printResult(winningResult)
}
