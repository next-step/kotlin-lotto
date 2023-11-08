package lotto.domain

@JvmInline
value class LottoBuyingPrice(
    val value: Int,
) {

    init {
        require(value >= LOTTO_PRICE) {
            "로또 구입 금액은 ${LOTTO_PRICE}원 이상이어야 합니다."
        }
    }

    fun divide(value: Int): Int {
        return this.value.div(value)
    }

    fun minus(value: Int): Int {
        return this.value.minus(value)
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
