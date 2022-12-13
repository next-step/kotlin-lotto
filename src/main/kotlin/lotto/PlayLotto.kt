package lotto

import lotto.controller.LottoController
import lotto.service.RandomLottoGenerator

fun main() {
    LottoController(RandomLottoGenerator()).playLotto()
}
