import lotto.domain.LottoGame
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    try {
        val lottoGame = LottoGame(InputView.getGameMoney())
        ResultView.showLottos(lottoGame.lottos)
        lottoGame.execute(InputView.getPrizedNumbers())
        ResultView.showPrizeStatics(lottoGame.lottoPrizeStatics)
    } catch (e: Exception) {
        println(e.message)
    }
}
