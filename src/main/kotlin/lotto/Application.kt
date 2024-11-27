package lotto

import lotto.application.LottoService
import lotto.application.RandomLottoLineGenerator
import lotto.ui.LottoController

object Application {
    private fun lottoLineGenerator() = RandomLottoLineGenerator()

    private fun lottoService() = LottoService(lottoLineGenerator())

    fun lottoController() = LottoController(lottoService())
}

fun main() {
    val controller = Application.lottoController()
    controller.play()
}
