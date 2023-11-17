package lotto.model

data class PurchaseGames(
    val totalGameCount: Int,
    val manualGameCount: Int,
    val manualIssuedGames: List<Game>,
) {
    init {
        require(totalGameCount >= manualGameCount) { "총 구매 수량[$totalGameCount]보다 많은 수의 수동 발권 수량[$manualGameCount] 입력은 불가능합니다 " }
        requirePositive(totalGameCount)
        requirePositive(manualGameCount)
    }

    private fun requirePositive(input: Int) {
        require(input > 0) { "발권 수량은 양의 정수만 가능 합니다" }
    }

    private fun autoIssueCount(): Int {
        return this.totalGameCount - this.manualGameCount
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
