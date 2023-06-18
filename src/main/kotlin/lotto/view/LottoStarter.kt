package lotto.view

import shffule.RandomShuffler
import lotto.domain.analysis.RealLottoResultAnalyst
import lotto.domain.shop.RealLottoShop
import lotto.domain.shop.machine.RealLottoGameMachine

fun startLotto() {
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
