import domain.LottoPurchaseInfo
import presentation.InputView
import presentation.OutputView
import service.LottoService

val lottoService = LottoService()

fun main() {
    val amount = InputView.inputPurchaseAmount()
    val purchaseManualLottoCount = InputView.inputPurchaseManualLotto()
    val manualLottos = InputView.inputManualLottoNumbers(purchaseManualLottoCount)

    val lottoPurchaseInfo = LottoPurchaseInfo(amount, manualLottos)

    OutputView.printLottoCount(lottoPurchaseInfo)
    val lottos = lottoService.purchaseLottoTicket(lottoPurchaseInfo)
    lottos.lottos.forEach {
        OutputView.printLotto(it)
    }

    val winningResult = lottoService.getWinningResult(lottos, InputView.inputWinningNumbers(), lottoPurchaseInfo.calculatePurchaseAmount())
    OutputView.printResult(winningResult)
}
