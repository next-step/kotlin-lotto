package lotto.model

object TicketIssuer {
    private const val PRICE_PER_GAME = 1000

    fun transaction(purchaseGames: PurchaseGames): Tickets {
        val games = autoIssue(purchaseGames.autoIssueCount())
        val manualIssue = manualIssue(purchaseGames)
        return Tickets(games + manualIssue)
    }

    private fun manualIssue(purchaseGames: PurchaseGames): List<Game> {
        val split = purchaseGames.manualIssueInput.split("\n")
        val mutableList = mutableListOf<Game>()
        for (s in split) {
            val game = Game(
                LottoNumbers(
                    s.split(", ")
                        .asSequence()
                        .map { it.toInt() }
                        .toList()
                )
            )
            mutableList.add(game)
        }
        return mutableList
    }

    fun pricePerGame(): Int {
        return PRICE_PER_GAME
    }

    private fun autoIssue(count: Int): List<Game> {
        return List(count) { Game.autoTicket() }
    }
}
