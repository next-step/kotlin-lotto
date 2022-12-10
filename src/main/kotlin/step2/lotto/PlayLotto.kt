package step2.lotto

import step2.lotto.controller.LottoController
import step2.lotto.service.RandomLottoGenerator

fun main() {
    LottoController(RandomLottoGenerator()).playLotto()
}
