
import lotto.LottoGame
import lotto.io.InputView

fun main() {
    val amount = InputView.getAmount()
    LottoGame(amount).start()
}
