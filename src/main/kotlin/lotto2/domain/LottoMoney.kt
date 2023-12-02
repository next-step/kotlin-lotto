package lotto2.domain

data class LottoMoney(private var balance: Int) {
    init {
        require(balance >= MIN_LOTTO_MONEY) { "초기 금액은 0원 이상이어야 합니다." }
    }

    fun subtract(amount: Int) {
        require(balance - amount >= MIN_LOTTO_MONEY) { "잔액이 부족합니다. 부족한 금액: ${MIN_LOTTO_MONEY - (balance - amount)}" }

        balance -= amount
    }

    fun toPurchasableTicketQuantity(): Int {
        return balance / LottoShop.LOTTO_PRICE
    }

    companion object {
        private const val MIN_LOTTO_MONEY = 0
    }
}
