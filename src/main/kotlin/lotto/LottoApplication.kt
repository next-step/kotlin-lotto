package lotto

import lotto.application.LottoStatisticsService
import lotto.controller.LottoController

fun main() {
    val controller = LottoController(LottoStatisticsService())
    controller.start()
}
