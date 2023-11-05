package lotto.domain

@JvmInline
value class TicketCount(
    val value: Int
) {

    companion object {
        fun from(amount: Amount): TicketCount =
            TicketCount(calculateCount(amount))

        private fun calculateCount(amount: Amount): Int {
            require(amount.value % LottoSpec.PRICE == 0) { "로또를 구매하려면 구매 금액이 로또 금액의 배수여야 합니다" }
            return amount.value / LottoSpec.PRICE
        }
    }
}
