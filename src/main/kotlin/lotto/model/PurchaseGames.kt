package lotto.model

data class PurchaseGames(
    val totalGameCount: Int,
    val manualIssuedGames: List<Game>,
) {
    init {
        requirePositive(totalGameCount)
        requirePositive(manualIssuedGames.size)
    }

    private fun requirePositive(input: Int) {
        require(input > 0) { "발권 수량은 양의 정수만 가능 합니다" }
    }

    private fun autoIssueCount(): Int {
        return this.totalGameCount - this.manualIssuedGames.size
    }

    private fun autoIssuedGames(): List<Game> {
        return List(autoIssueCount()) { Game.autoTicket() }
    }

    fun manual(): LottoTicket {
        return LottoTicket(manualIssuedGames)
    }

    fun auto(): LottoTicket {
        return LottoTicket(autoIssuedGames())
    }

    companion object {

        private const val PRICE_OF_GAME = 1000

        fun priceOfGame(): Int {
            return PRICE_OF_GAME
        }
    }
}
