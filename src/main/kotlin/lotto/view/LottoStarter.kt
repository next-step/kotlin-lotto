package lotto.view

import lotto.domain.RealLottoShop

fun startLotto() {
    LottoController(
        lottoShop = RealLottoShop(),
    ).start()
}
