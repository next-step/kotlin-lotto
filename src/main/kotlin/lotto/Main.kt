package lotto

import lotto.controller.LottoFactory
import lotto.controller.LottoGame
import lotto.controller.LottoShop
import lotto.domain.numberGenerator.RandomLottoNumberGenerator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val input = InputView()
    val output = ResultView()
    val lottoFactory = LottoFactory(RandomLottoNumberGenerator())
    val lottoGame = LottoGame(input, output, LottoShop(lottoFactory))
    lottoGame.start()
}
