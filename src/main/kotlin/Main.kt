import lotto.view.ResultView
import lotto.domain.LottoShop
import lotto.domain.LottoStatistics
import lotto.view.InputView

fun main() {
    val input = InputView()
    val purchasePrice = input.inputPurchasePrice()
    val lottos = LottoShop(purchasePrice).sellLotto()
    val resultView = ResultView()
    resultView.showLottoCount(lottos)
    resultView.showLottos(lottos)
    val lastWinnerNumbers = input.inputLastWinNumbers()
    val statistics = LottoStatistics(lottos)
    val resultMap = statistics.calculate(lastWinnerNumbers)
    val rating = statistics.getRating(purchasePrice, resultMap)

    resultView.showStatisticsResult(resultMap)
    resultView.showWinRating(rating)
}

