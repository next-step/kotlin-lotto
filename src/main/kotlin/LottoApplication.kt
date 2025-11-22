import domain.Amount
import presentation.InputView
import presentation.OutputView
import service.LottoService

val lottoService = LottoService()

fun main() {
    val amount = Amount(InputView.inputPurchaseAmount())
    val purchaseLottoCount = amount.calculatePurchaseLottoCount()
    OutputView.printLottoCount(purchaseLottoCount, amount.calculateChange())

    val lottoTicket = lottoService.generateLottoTicket(purchaseLottoCount)
    lottoTicket.lottoTicket.forEach {
        OutputView.printLotto(it.lotto)
    }

    val winningResult = lottoService.getWinningResult(lottoTicket, InputView.inputWinningNumbers(), amount.calculatePurchaseAmount())
    OutputView.printResult(winningResult)
}
