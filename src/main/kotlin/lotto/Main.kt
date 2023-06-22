package lotto

import lotto.controller.LottoFactory
import lotto.controller.LottoGame
import lotto.domain.numberGenerator.RandomLottoLottoNumberGenerator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val input = InputView()
    val output = ResultView()
    val lottoFactory = LottoFactory(RandomLottoLottoNumberGenerator())
    val lottoGame = LottoGame(input, output, lottoFactory)
    lottoGame.start()
}
