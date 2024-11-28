package lotto

data class Price(val value: Int) {
    fun getPurchasableCount(minPrice: Int): Int {
        return value / minPrice
    }

    init {
        require(value >= 0) { "음수는 입력할 수 없습니다." }
    }
}
