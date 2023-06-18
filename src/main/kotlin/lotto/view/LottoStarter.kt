package lotto.view

import lotto.domain.shop.RealLottoShop

fun startLotto() {
    LottoController(
        lottoShop = RealLottoShop(),
    ).start()
}
