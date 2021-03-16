package lotto.supportdata

data class PurchaseInfo(val money: Int) {
    val ticketNumber: Int = money / BASE_MONEY

    companion object {
        const val BASE_MONEY = 1000
    }
}
