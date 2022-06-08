package lotto.domain

private const val MIN_PURCHASED_MONEY = 0
private const val LOTTO_UNIT_PRICE = 1_000

@JvmInline
value class PurchasedMoney(
    private val _value: Int,
) {
    val value: Int
        get() = _value - (_value % LOTTO_UNIT_PRICE)

    init {
        require(_value >= MIN_PURCHASED_MONEY) { "구입 금액은 음수가 될 수 없습니다." }
    }

    fun calculateLottoNumber() = _value / LOTTO_UNIT_PRICE
}
