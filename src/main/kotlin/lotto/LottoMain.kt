import lotto.model.Buyer
import lotto.view.InputView

fun main() {
    val money = InputView.getAmountOfMoney()
    val lottos = Buyer().buyLotto(money)
}
