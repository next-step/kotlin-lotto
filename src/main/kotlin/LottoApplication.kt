import domain.lotto.LottoNumber
import domain.purchase.LottoPurchaseInfo
import domain.winning.WinningLotto
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

    val lottoTicket = lottoService.purchaseLottoTicket(lottoPurchaseInfo)
    lottoTicket.lottos.forEach {
        OutputView.printLotto(it)
    }

    val winningLottoNumbers = InputView.inputWinningNumbers()
    val bonusNumber = InputView.inputBonusNumber()
    val winningResult =
        lottoService.getWinningResult(
            lottoTicket,
            WinningLotto(winningLottoNumbers, LottoNumber(bonusNumber)),
            lottoPurchaseInfo.purchaseLottoCount,
        )
    OutputView.printResult(winningResult)
}
