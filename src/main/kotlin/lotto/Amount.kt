package lotto

@JvmInline
value class Amount(val value: Int) {
    init {
        require(value >= 0) { "금액은 0 이상이어야 합니다." }
    }

    fun divide(divisor: Int): Int {
        return value.div(divisor)
    }
}
