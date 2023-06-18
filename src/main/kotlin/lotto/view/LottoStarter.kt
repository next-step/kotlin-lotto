package lotto.view

import lotto.domain.shop.RealLottoShop

fun startLotto() {
    LottoController(
        lottoInputView = RealLottoInputView(),
        lottoShop = RealLottoShop(),
    ).start()
}
