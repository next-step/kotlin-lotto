package lotto

data class Price(val value: Int) {
    init {
        require(value >= 0) { "음수는 입력할 수 없습니다." }
    }

    fun getPurchasableCount(minPrice: Int): Int {
        return value / minPrice
    }
}
