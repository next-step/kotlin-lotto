import domain.lotto.LottoNumber
import domain.purchase.LottoPurchaseInfo
import presentation.InputView
import presentation.OutputView
import service.AutomaticLottoGenerateService
import service.LottoService
import service.ProfitCalculator

val lottoService = LottoService(ProfitCalculator(), AutomaticLottoGenerateService())

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

    val winningLotto = InputView.inputWinningNumbers()
    val bonusNumber = InputView.inputBonusNumber()
    val winningResult =
        lottoService.getWinningResult(
            lottos,
            winningLotto,
            LottoNumber(bonusNumber),
            lottoPurchaseInfo.calculatePurchaseAmount(),
        )
    OutputView.printResult(winningResult)
}
