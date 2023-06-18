import lotto.view.ResultView
import lotto.domain.LottoShop
import lotto.view.InputView

fun main() {
    val input = InputView()
    val purchasePrice = input.inputPurchasePrice()
    val lottos = LottoShop(purchasePrice).sellLotto()
    val resultView = ResultView()
    resultView.showLottoCount(lottos)
    resultView.showLottos(lottos)
    val lastWinnerNumbers = input.inputLastWinNumbers()

}
