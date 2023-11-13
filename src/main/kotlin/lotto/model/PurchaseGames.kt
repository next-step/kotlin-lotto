package lotto.model

data class PurchaseGames(
    val totalGameCount: Int,
    val manualGameCount: Int,
    val manualTicketingInput: String,
) {
    init {
        require(totalGameCount >= manualGameCount) { "총 구매 수량[$totalGameCount]보다 많은 수의 수동 발권 수량[$manualGameCount] 입력은 불가능합니다 " }
        requirePositive(totalGameCount)
        requirePositive(manualGameCount)
        requireTicketString()
    }

    private fun requireTicketString() {
        TicketIssuer.manualIssue(this)
    }

    private fun requirePositive(input: Int) {
        require(input > 0) { "발권 수량은 양의 정수만 가능 합니다" }
    }

    fun autoIssueCount(): Int {
        return this.totalGameCount - this.manualGameCount
    }
}
