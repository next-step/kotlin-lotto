package lotto.domain.purchase

import lotto.domain.Lotto

@JvmInline
value class LottoBuyingPrice(
    val value: Int,
) {

    init {
        require(value >= Lotto.LOTTO_PRICE) {
            "로또 구입 금액은 ${Lotto.LOTTO_PRICE}원 이상이어야 합니다."
        }
    }

    fun divide(value: Int): Int =
        this.value.div(value)

    fun minus(value: Int): Int =
        this.value.minus(value)
}
