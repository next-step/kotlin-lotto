package lotto.model

object Issuer {
    private const val PRICE_PER_GAME = 1000

    fun transaction(gameCount: Int): Round {
        return Round(
            (1..gameCount)
                .map { Game.autoTicket() }
        )
    }

    fun pricePerGame(): Int {
        return PRICE_PER_GAME
    }
}
