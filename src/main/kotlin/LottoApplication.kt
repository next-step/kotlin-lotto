import domain.Amount
import domain.LottoShuffler
import domain.LottoWinningType
import domain.Lottos
import domain.ProfitCalculator
import presentation.InputView
import presentation.OutputView

fun main() {
    val inputPurchaseAmount = InputView.inputPurchaseAmount()
    val amount = Amount(inputPurchaseAmount.toInt())
    val purchaseLottoCount = amount.calculatePurchaseLottoCount()
    OutputView.printLottoCount(purchaseLottoCount, amount.calculateChange())

    val lottos = Lottos()

    repeat(purchaseLottoCount) {
        val generateAutomaticLotto = LottoShuffler.generateAutomaticLotto()
        lottos.addLotto(generateAutomaticLotto)
        OutputView.printLotto(generateAutomaticLotto)
    }

    val winningNumbers = InputView.inputWinningNumbers()
    val result: Map<LottoWinningType, Int> =
        lottos.lottos
            .groupingBy { LottoWinningType.getLottoWinningType(winningNumbers, it) }
            .eachCount()
            .withDefault { 0 }

    val profitCalculator = ProfitCalculator(result, amount.calculatePurchaseAmount())
    OutputView.printResult(profitCalculator)
}
