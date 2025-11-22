import domain.Amount
import presentation.InputView
import presentation.OutputView
import service.LottoService

val lottoService = LottoService()

fun main() {
    val amount = Amount(InputView.inputPurchaseAmount())
    val purchaseLottoCount = amount.calculatePurchaseLottoCount()
    OutputView.printLottoCount(purchaseLottoCount, amount.calculateChange())

    val lottos = lottoService.generateLottos(purchaseLottoCount)
    lottos.lottos.forEach {
        OutputView.printLotto(it.lotto)
    }

    val winningResult = lottoService.getWinningResult(lottos, InputView.inputWinningNumbers(), amount.calculatePurchaseAmount())
    OutputView.printResult(winningResult)
}
