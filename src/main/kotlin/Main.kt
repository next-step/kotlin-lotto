import lotto.domain.*
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    try {
        val lottoGameMoney = getLottoGameMoney()
        val manualLottoCount = getManualLottoCount(lottoGameMoney)
        val lottoGame = LottoGame.of(lottoGameMoney, getManualLottoList(manualLottoCount))

        showGameResult(lottoGame)
    } catch (e: Exception) {
        ResultView.showErrorMessage(e.message)
    }
}

fun getManualLottoCount(lottoGameMoney: LottoGameMoney): NumberOfManualLotto {
    val numberOfManualLotto: NumberOfManualLotto? =
        NumberOfManualLotto.of(InputView.getManualLottoCount(), lottoGameMoney)
    if (numberOfManualLotto != null) return numberOfManualLotto
    return getManualLottoCount(lottoGameMoney)
}

tailrec fun getLottoGameMoney(): LottoGameMoney {
    val gameMoney: LottoGameMoney? = LottoGameMoney.from(InputView.getGameMoney())
    if (gameMoney != null) return gameMoney
    return getLottoGameMoney()
}

fun getManualLottoList(numberOfManualLotto: NumberOfManualLotto): List<Lotto> {
    val manualLottoList: MutableList<Lotto> = mutableListOf()
    InputView.getManualLottoNumbers(numberOfManualLotto.count).forEach {
        val lotto = Lotto.from(it)
        if (lotto != null) manualLottoList.add(lotto)
    }
    if (numberOfManualLotto.count != manualLottoList.size) getManualLottoList(numberOfManualLotto - manualLottoList.size)
    return manualLottoList
}

tailrec fun showGameResult(lottoGame: LottoGame) {
    val result = lottoGame.execute(InputView.getWinningLotto())
    when (result) {
        is LottoGameResult.Success -> {
            ResultView.showResult(result)
            return
        }
        is LottoGameResult.InvalidBonusNumber,
        is LottoGameResult.IsContainBonusNumber,
        is LottoGameResult.InvalidPrizeLotto -> ResultView.showErrorMessage(result)
    }.exhaustive
    showGameResult(lottoGame)
}
