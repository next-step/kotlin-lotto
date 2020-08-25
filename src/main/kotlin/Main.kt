import lotto.domain.Lotto
import lotto.domain.LottoGame
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

    var prizeLotto: Lotto? = null
    while (prizeLotto == null) {
        prizeLotto = Lotto.from(InputView.getPrizedNumbers())
    }

    lottoGame.execute(prizeLotto, InputView.getBonusNumber())
    ResultView.showPrizeStatics(lottoGame.lottoPrizeStatics)
}
