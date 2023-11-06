package lotto.app

import lotto.model.Game
import lotto.model.Round

object LottoApp {
    private const val PRICE_PER_GAME = 1000

    fun transaction(gameCount: Int): Round {
        return Round(
            ArrayDeque(
                (1..gameCount).map { Game.autoTicket() }
            )
        )
    }

    fun pricePerGame(): Int {
        return this.PRICE_PER_GAME
    }
}
