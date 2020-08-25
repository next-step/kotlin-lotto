import lotto.domain.*
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoGameMoney = getLottoGameMoney()
    val manualLottoCount = getManualLottoCount(lottoGameMoney)
    val lottoGame = LottoGame.of(lottoGameMoney, getManualLottoList(manualLottoCount))

    ResultView.showLottoList(lottoGame.lottoList)

    showGameResult(lottoGame)
}

fun getManualLottoCount(lottoGameMoney: LottoGameMoney): ManualLottoCount {
    val manualLottoCount: ManualLottoCount? = ManualLottoCount.from(InputView.getManualLottoCount(), lottoGameMoney)
    while (manualLottoCount == null) {
        ResultView.showErrorMessage(manualLottoCount)
        getManualLottoCount(lottoGameMoney)
    }
    return manualLottoCount
}

fun getLottoGameMoney(): LottoGameMoney {
    val gameMoney: LottoGameMoney? = LottoGameMoney.from(InputView.getGameMoney())
    while (gameMoney == null) {
        ResultView.showErrorMessage(gameMoney)
        getLottoGameMoney()
    }
    return gameMoney
}

fun getManualLottoList(manualLottoCount: ManualLottoCount): List<Lotto> {
    val manualLottoList: MutableList<Lotto> = mutableListOf()
    while (manualLottoCount.count != manualLottoList.size) {
        val lotto = Lotto.from(InputView.getManualLottoNumbers())
        if (lotto != null) manualLottoList.add(lotto)
    }
    return manualLottoList
}

fun showGameResult(lottoGame: LottoGame) {
    val result = lottoGame.execute(InputView.getPrizedNumbers(), InputView.getBonusNumber())
    when (result) {
        is LottoGameResult.Success -> {
            ResultView.showPrizeStatics(result.lottoPrizeStatics)
            return
        }
        is LottoGameResult.InvalidBonusNumber,
        is LottoGameResult.IsContainBonusNumber,
        is LottoGameResult.InvalidPrizeLotto -> ResultView.showErrorMessage(result)
    }.exhaustive
    showGameResult(lottoGame)
}
