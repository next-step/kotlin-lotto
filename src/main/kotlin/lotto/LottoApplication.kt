package lotto

import lotto.controller.LottoController
import lotto.domain.LottoGenerator
import lotto.domain.LottoStatistics

fun main() {
    val lottoController = LottoController(LottoGenerator(), LottoStatistics())
    lottoController.start()
}
