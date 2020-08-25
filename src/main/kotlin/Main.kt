import lotto.domain.*
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoGameMoney = getLottoGameMoney()
    val manualLottoCount = InputView.getManualLottoCount().toInt()
    val lottoGame = LottoGame.of(lottoGameMoney, getManualLottoList(manualLottoCount))

    ResultView.showLottoList(lottoGame.lottoList)

    showGameResult(lottoGame)
}

fun getLottoGameMoney(): LottoGameMoney {
    val gameMoney: LottoGameMoney? = LottoGameMoney.from(InputView.getGameMoney())
    ResultView.showErrorMessage(gameMoney)
    if (gameMoney == null) getLottoGameMoney()
    return gameMoney!!
}

fun getManualLottoList(manualLottoCount: Int): List<Lotto> {
    val manualLottoList: MutableList<Lotto> = mutableListOf()
    while (manualLottoCount != manualLottoList.size) {
        val lotto = Lotto.from(InputView.getManualLottoNumbers())
        if (lotto != null) manualLottoList.add(lotto)
    }
    return manualLottoList
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
