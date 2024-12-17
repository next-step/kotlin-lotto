package lotto

import lotto.controller.LottoController
import lotto.domain.LottoGame
import lotto.repository.LottoRepository

private val lottoController = LottoController(LottoGame(LottoRepository()))

fun main() {
    lottoController.gameStart()
}
