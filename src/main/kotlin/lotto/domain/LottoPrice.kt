package lotto.domain

import lotto.domain.LottoBuyingStrategy.Companion.LOTTO_PRICE

@JvmInline
value class LottoPrice(private val amount: Int) : LottoBuyingStrategy {
    init {
        require(amount >= LOTTO_PRICE) { "로또 구입 금액은 ${LOTTO_PRICE}원 이상이어야 합니다." }
    }

    constructor(amount: String) : this(
        amount.toIntOrNull() ?: throw IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.")
    )

    override fun count(): Int {
        return amount / LOTTO_PRICE
    }
}
