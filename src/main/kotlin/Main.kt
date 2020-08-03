import lotto.InputView
import lotto.LottoGame
import lotto.ResultView

fun main() {
    try {
        val count = InputView.getCount()
        val lotto = LottoGame(count)

        while (!lotto.isEnd()) {
            val lottoNumber = lotto.createLotto()
            ResultView.showLottoNumber(lottoNumber)
        }

        val prizedNumbers = InputView.getPrizedNumbers()
        val prizedLotto = lotto.checkPrize(prizedNumbers)

        ResultView.showPrizeStatics(prizedLotto, lotto.profitRate)
    } catch (e: Exception) {
        println(e.message)
    }
}
