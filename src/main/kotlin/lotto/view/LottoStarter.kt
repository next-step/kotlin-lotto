package lotto.view

import common.shffule.RandomShuffler
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
    ).start()
}
