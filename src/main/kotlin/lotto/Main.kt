package lotto

import lotto.domain.LottoGame
import lotto.ui.ConsoleInput
import lotto.ui.ConsoleOutput

fun main() {
    val lottoGame = LottoGame(ConsoleInput(), ConsoleOutput())
    lottoGame.run()
}
