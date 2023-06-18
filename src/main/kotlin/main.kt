import lotto.domain.analysis.LottoResultAnalyst
import lotto.domain.shop.RealLottoShop
import lotto.domain.shop.LottoGameMachine
import lotto.view.LottoController
import lotto.view.RealLottoInputView
import lotto.view.RealLottoResultView
import shffule.RandomShuffler

fun main() {
    LottoController(
        lottoInputView = RealLottoInputView(),
        lottoResultView = RealLottoResultView(),
        lottoShop = RealLottoShop(
            lottoGameMachine = LottoGameMachine(
                shuffler = RandomShuffler(),
            ),
        ),
        lottoResultAnalyst = LottoResultAnalyst(),
    ).start()
}
