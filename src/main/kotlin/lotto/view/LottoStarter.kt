package lotto.view

import lotto.domain.shop.RealLottoShop

fun startLotto() {
    LottoController(
        lottoInputView = RealLottoInputView(),
        lottoResultView = RealLottoResultView(),
        lottoShop = RealLottoShop(),
    ).start()
}
