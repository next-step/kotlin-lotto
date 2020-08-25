import lotto.domain.Lotto
import lotto.domain.LottoGame
import lotto.domain.LottoGameResult
import lotto.domain.exhaustive
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val gameMoney = InputView.getGameMoney()
    val manualLottoCount = InputView.getManualLottoCount().toInt()
    val manualLottoList: MutableList<Lotto> = mutableListOf()

    while (manualLottoCount != manualLottoList.size) {
        val lotto = Lotto.from(InputView.getManualLottoNumbers())
        if (lotto != null) manualLottoList.add(lotto)
    }
    val lottoGame = LottoGame.of(gameMoney, manualLottoList)

    ResultView.showLottoList(lottoGame.lottoList)

    showGameResult(lottoGame)
}

fun showGameResult(lottoGame: LottoGame) {
    val result = lottoGame.execute(InputView.getPrizedNumbers(), InputView.getBonusNumber())
    when (result) {
        is LottoGameResult.Success -> {
            ResultView.showPrizeStatics(lottoGame.lottoPrizeStatics)
            return
        }
        is LottoGameResult.InvalidBonusNumber,
        is LottoGameResult.IsContainBonusNumber,
        is LottoGameResult.InvalidPrizeLotto -> ResultView.showErrorMessage(result)
    }.exhaustive
    showGameResult(lottoGame)
}
