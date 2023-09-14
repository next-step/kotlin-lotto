package lottogame

import lottogame.domain.LottoGame
import lottogame.ui.ConsoleInput
import lottogame.ui.ConsoleOutput

fun main() {
    val lottoGame = LottoGame(ConsoleInput(), ConsoleOutput())
    lottoGame.run()
}
