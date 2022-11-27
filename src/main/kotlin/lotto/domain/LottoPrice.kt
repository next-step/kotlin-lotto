package lotto.domain

@JvmInline
value class LottoPrice(internal val value: Int) {
    init {
        require(value >= LOTTO_PRICE) { "로또 구입 금액은 ${LOTTO_PRICE}원 이상이어야 합니다." }
    }

    constructor(amount: String) : this(
        amount.toIntOrNull() ?: throw IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.")
    )

    fun count(): Int {
        return value / LOTTO_PRICE
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
