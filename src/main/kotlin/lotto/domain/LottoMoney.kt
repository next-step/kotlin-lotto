package lotto.domain

private const val MONEY_PER_TICKET = 1000

@JvmInline
value class LottoMoney(val value: Int) {

    init {
        require(value >= 0) { "금액은 0 이상입니다" }
        require(value % MONEY_PER_TICKET == 0) { "1000원 단위의 금액만 허용합니다" }
    }

    fun calculateChange(count: LottoTicketCount): LottoMoney {
        return LottoMoney(value - count.value * MONEY_PER_TICKET)
    }

    fun calculateCount(): LottoTicketCount {
        return LottoTicketCount(value / MONEY_PER_TICKET)
    }
}
