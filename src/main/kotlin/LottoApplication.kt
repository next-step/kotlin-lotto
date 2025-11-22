import domain.Amount
import presentation.InputView
import presentation.OutputView
import service.LottoService

val lottoService = LottoService()

fun main() {
    val amount = Amount(InputView.inputPurchaseAmount())
    OutputView.printLottoCount(amount)

    val lottoTicket = lottoService.generateLottoTicket(amount.getPurchaseLottoCount())
    lottoTicket.lottoTicket.forEach {
        OutputView.printLotto(it.lotto)
    }

    val winningResult = lottoService.getWinningResult(lottoTicket, InputView.inputWinningNumbers(), amount.getPurchaseAmount())
    OutputView.printResult(winningResult)
}
