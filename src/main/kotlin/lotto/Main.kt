package lotto

import lotto.controller.LottoFactory
import lotto.controller.LottoGame
import lotto.controller.LottoShop
import lotto.domain.numberGenerator.RandomLottoLottoNumberGenerator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val input = InputView()
    val output = ResultView()
    val lottoFactory = LottoFactory(RandomLottoLottoNumberGenerator())
    val lottoGame = LottoGame(input, output, LottoShop(lottoFactory))
    lottoGame.start()
}
