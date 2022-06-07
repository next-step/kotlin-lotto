package lotto

import lotto.controller.LottoController
import lotto.service.LottoService

fun main() {

    val lottoService = LottoService()

    val lottoController = LottoController(lottoService)

    lottoController.start()
}
