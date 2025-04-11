package lotto

data class Order(
    private val money: Int,
    val manualTicketNumber: Int,
    val lottoNumbers: List<List<Int>>,
) {
    init {
        require((money / LOTTO_PRICE) >= manualTicketNumber) { ERROR_TICKET_NUMBER }
    }

    val autoTicketNumber = money / LOTTO_PRICE - manualTicketNumber

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val ERROR_TICKET_NUMBER = "Manual ticket number cannot exceed total ticket number"
    }
}
