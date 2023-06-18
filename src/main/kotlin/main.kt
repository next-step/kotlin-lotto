import lotto.domain.analysis.RealLottoResultAnalyst
import lotto.domain.shop.RealLottoShop
import lotto.domain.shop.machine.RealLottoGameMachine
import lotto.view.LottoController
import lotto.view.RealLottoInputView
import lotto.view.RealLottoResultView
import shffule.RandomShuffler

fun main() {
    LottoController(
        lottoInputView = RealLottoInputView(),
        lottoResultView = RealLottoResultView(),
        lottoShop = RealLottoShop(
            lottoGameMachine = RealLottoGameMachine(
                shuffler = RandomShuffler(),
            ),
        ),
        lottoResultAnalyst = RealLottoResultAnalyst(),
    ).start()
}
