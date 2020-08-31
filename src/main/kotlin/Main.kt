import lotto.domain.Lotto
import lotto.domain.LottoGame
import lotto.domain.LottoGameMoney
import lotto.domain.LottoGameResult
import lotto.domain.NumberOfManualLotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    try {
        val lottoGameMoney = getLottoGameMoney()
        val manualLottoCount = getManualLottoCount(lottoGameMoney)
        val lottoGame = LottoGame.of(lottoGameMoney, getManualLottoList(manualLottoCount))

        ResultView.showLottoList(lottoGame.lottoList)

        showGameResult(lottoGame)
    } catch (e: Exception) {
        ResultView.showErrorMessage(e.message)
    }
}

fun getManualLottoCount(lottoGameMoney: LottoGameMoney): NumberOfManualLotto {
    val numberOfManualLotto: NumberOfManualLotto? = NumberOfManualLotto.of(InputView.getManualLottoCount(), lottoGameMoney)
    while (numberOfManualLotto == null) {
        ResultView.showErrorMessage(numberOfManualLotto)
        getManualLottoCount(lottoGameMoney)
    }
    return numberOfManualLotto
}

fun getLottoGameMoney(): LottoGameMoney {
    val gameMoney: LottoGameMoney? = LottoGameMoney.from(InputView.getGameMoney())
    while (gameMoney == null) {
        ResultView.showErrorMessage(gameMoney)
        getLottoGameMoney()
    }
    return gameMoney
}

fun getManualLottoList(numberOfManualLotto: NumberOfManualLotto): List<Lotto> {
    val manualLottoList: MutableList<Lotto> = mutableListOf()
    while (numberOfManualLotto.count != manualLottoList.size) {
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
