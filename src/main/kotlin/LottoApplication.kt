import domain.Amount
import domain.LottoShuffler
import domain.Lottos
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
}
