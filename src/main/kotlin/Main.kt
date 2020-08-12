import lotto.domain.LottoGame
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    try {
        val lottoGame = LottoGame(InputView.getGameMoney())
        ResultView.showLottoList(lottoGame.lottoList)
        lottoGame.execute(InputView.getPrizedNumbers(), InputView.getBonusNumber())
        ResultView.showPrizeStatics(lottoGame.lottoPrizeStatics)
    } catch (e: Exception) {
        println(e.message)
    }
}
