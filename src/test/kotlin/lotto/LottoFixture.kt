package lotto

import lotto.model.Game
import lotto.model.LottoNumber
import lotto.model.Round
import lotto.model.WinningNumbers

object LottoFixture {
    val game1: Game = gameOf(1, 2, 3, 4, 5, 6)
    val game2: Game = gameOf(7, 8, 9, 10, 11, 12)
    val game3: Game = gameOf(1, 11, 21, 31, 41, 51, 52)
    val game4: Game = gameOf(2, 22, 32, 42, 52, 53)
    val Round: Round = roundOf(game1, game2, game3, game4)
    val winner1st: WinningNumbers = WinningNumbers(gameOf(1, 2, 3, 4, 5, 6))
    val winner3rd: WinningNumbers = WinningNumbers(gameOf(2, 3, 4, 5, 6, 37))
    val winner4rd: WinningNumbers = WinningNumbers(gameOf(3, 4, 5, 6, 37, 38))
    val winner5rd: WinningNumbers = WinningNumbers(gameOf(4, 5, 6, 37, 38, 39))

    private fun roundOf(vararg game: Game): Round {
        return Round(
            ArrayDeque(
                game.toList()
            )
        )
    }

    private fun gameOf(vararg values: Int): Game {
        return Game(
            values
                .map { LottoNumber(it) }
                .toSet()
        )
    }


}
