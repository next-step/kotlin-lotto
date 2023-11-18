package lotto.model

import lotto.model.strategy.LottoNumberStrategy

data class LottoPurchaseInfo(
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
        require(input >= 0) { "발권 수량은 0 또는 양의 정수만 가능 합니다" }
    }

    private fun autoIssueCount(): Int {
        return this.totalPurchaseCount - this.manualIssuedGames.size
    }

    private fun autoIssuedGames(strategy: LottoNumberStrategy): List<Game> {
        return List(autoIssueCount()) { Game.of(strategy) }
    }

    fun lottoTicketManual(): LottoTicket {
        return LottoTicket(manualIssuedGames)
    }

    fun lottoTicketAuto(strategy: LottoNumberStrategy): LottoTicket {
        return LottoTicket(autoIssuedGames(strategy))
    }

    companion object {

        private const val PRICE_OF_GAME = 1000

        fun priceOfGame(): Int {
            return PRICE_OF_GAME
        }
    }
}
