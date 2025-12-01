import domain.LottoPurchaseInfo
import presentation.InputView
import presentation.OutputView
import service.LottoService

val lottoService = LottoService()

fun main() {
    val amount = InputView.inputPurchaseAmount()
    val purchaseManualLottoCount = InputView.inputPurchaseManualLotto()
    val lottoPurchaseInfo = LottoPurchaseInfo(amount, purchaseManualLottoCount)

    OutputView.printLottoCount(lottoPurchaseInfo)

    val lottos = lottoService.purchaseAutomaticLottoTicket(lottoPurchaseInfo.calculateAutoLottoCount())
    lottos.lottos.forEach {
        OutputView.printLotto(it)
    }

    val winningResult = lottoService.getWinningResult(lottos, InputView.inputWinningNumbers(), lottoPurchaseInfo.calculatePurchaseAmount())
    OutputView.printResult(winningResult)
}
