package lotto

import lotto.controller.LottoController

fun main() {
    LottoController().apply {
        run()
        runByImmutableMoney()
    }
}
