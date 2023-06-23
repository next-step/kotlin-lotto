import lotto.domain.LottoShop
import lotto.domain.LottoStatistics
import lotto.domain.Winner
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val input = InputView()
    val purchasePrice = input.inputPurchasePrice()

    val lottos = LottoShop(purchasePrice).sellLotto()
    val resultView = ResultView()
    resultView.showLottoCount(lottos)
    resultView.showLottos(lottos)

    val lastWinnerNumbers = input.inputLastWinNumbers()
    val bonusNumber = input.inputBonusNumber()

    val statistics = LottoStatistics()
    val rankMap = statistics.initStatisticsMap()

    lottos.forEach {
        val matchCount = it.getMatchCount(lastWinnerNumbers)
        val isBonusNumberContains = it.getBonusMatch(bonusNumber)
        Winner.findWinner(matchCount, isBonusNumberContains, rankMap)
    }
    val rating = statistics.getRating(purchasePrice, rankMap)

    resultView.showStatisticsResult(rankMap)
    resultView.showWinRating(rating)
}
