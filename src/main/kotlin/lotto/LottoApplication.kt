package lotto

import lotto.controller.LottoController
import lotto.domain.LottoShop
import lotto.domain.RandomLottoGenerator

fun main() {
    LottoController(LottoShop(RandomLottoGenerator())).play()
}
