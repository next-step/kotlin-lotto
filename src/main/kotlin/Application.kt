import lotto.model.Quantity
import lotto.view.InputView

fun main() {
    val quantity = Quantity(InputView().getAmountOfMoney()).quantity
    println(quantity)
}
