package lotto

data class Price(val value: Int) {
    fun isMoreThan(minPrice: Int): Boolean {
        return value >= minPrice
    }

    fun subtract(amount: Int): Price {
        require(value >= amount) { "잔액이 부족합니다. 현재 금액 = $value, 구매 금액 = $amount" }
        return Price(value - amount)
    }

    init {
        require(value >= 0) { "음수는 입력할 수 없습니다." }
    }
}
