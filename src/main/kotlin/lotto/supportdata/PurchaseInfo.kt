package lotto.supportdata

data class PurchaseInfo(val money: Int, val manualTickets: List<String> = emptyList()) {
    private val totalTicketNumber: Int = money / BASE_MONEY
    val manualTicketNumber: Int = manualTickets.size
    val autoTicketNumber: Int = totalTicketNumber - manualTicketNumber

    companion object {
        const val BASE_MONEY = 1000
    }
}
