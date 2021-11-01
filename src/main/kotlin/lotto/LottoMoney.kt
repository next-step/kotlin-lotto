package lotto

private const val MONEY_PER_TICKET = 1000

@JvmInline
value class LottoMoney(val value: Int) {

    init {
        require(value >= 0) { "금액은 0 이상입니다" }
        require(value % MONEY_PER_TICKET == 0) { "1000원 단위의 금액만 허용합니다" }
    }

    fun calculateChange(count: Int): LottoMoney {
        return LottoMoney(value - count * MONEY_PER_TICKET)
    }

    fun calculateCount(): Int {
        return value / MONEY_PER_TICKET
    }
}
