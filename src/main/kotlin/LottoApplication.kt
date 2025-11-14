import domain.Amount
import presentation.InputView
import presentation.OutputView

fun main() {
    val inputPurchaseAmount = InputView.inputPurchaseAmount()
    val amount = Amount(inputPurchaseAmount.toLong())
    OutputView.printLottoCount(amount.calculatePurchaseLottoCount(), amount.calculateChange())



}
