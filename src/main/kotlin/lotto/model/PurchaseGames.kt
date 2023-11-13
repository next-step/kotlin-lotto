package lotto.model

data class PurchaseGames(
    val totalGameCount: Int,
    val manualGameCount: Int,
    val manualTicketingInput: String,
) {
    init {
        require(totalGameCount >= manualGameCount) { "금액을 초과하는 수동발권은 불가능합니다" }
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

    fun manualIssueCount(): Int {
        return this.manualGameCount
    }

    fun autoIssueCount(): Int {
        return this.totalGameCount - this.manualGameCount
    }
}
