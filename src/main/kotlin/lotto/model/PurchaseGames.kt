package lotto.model

data class PurchaseGames(
    val totalPurchaseCount: Int,
    val manualIssuedGames: List<Game>,
) {
    init {
        requireManualCountUpperToTotalCount()
        requirePositive(totalPurchaseCount)
        requirePositive(manualIssuedGames.size)
    }

    private fun requireManualCountUpperToTotalCount() {
        require(totalPurchaseCount >= manualIssuedGames.size) { "총 구매 수량[$totalPurchaseCount]보다 많은 수의 수동 발권 수량[${manualIssuedGames.size}] 입력은 불가능합니다 " }
    }

    private fun requirePositive(input: Int) {
        require(input > 0) { "발권 수량은 양의 정수만 가능 합니다" }
    }

    private fun autoIssueCount(): Int {
        return this.totalPurchaseCount - this.manualIssuedGames.size
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
