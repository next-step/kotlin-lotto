package lotto

import lotto.controller.LottoController

fun main() {

    val lottoGameService = LottoGameService()

    val lottoController = LottoController(lottoGameService)

    lottoController.start()
}
