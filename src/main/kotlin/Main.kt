import lotto.view.InputView
import lotto.domain.LottoGame
import lotto.view.ResultView

fun main() {
    try {
        val gameMoney = InputView.getGameMoney()
        val lotto = LottoGame(gameMoney)

        ResultView.showLottoCount(lotto.count)

        val lottoNumber = lotto.createLotto()
        ResultView.showLottoNumber(lottoNumber)

        val prizedNumbers = InputView.getPrizedNumbers()
        val prizedLotto = lotto.execute(prizedNumbers)

        ResultView.showPrizeStatics(prizedLotto, lotto.profitRate)
    } catch (e: Exception) {
        println(e.message)
    }
}
