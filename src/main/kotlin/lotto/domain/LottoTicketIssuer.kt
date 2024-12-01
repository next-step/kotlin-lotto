package lotto.domain

object LottoTicketIssuer {
    fun issueTickets(
        amountPaid: Int,
        lottoNumberGenerator: () -> Set<Int>,
    ): PurchasedLottoTickets {
        checkAmountPaid(amountPaid)
        return PurchasedLottoTickets(
            purchasedCount = (amountPaid / DEFAULT_LOTTO_PRICE),
            lottoNumberGenerator = lottoNumberGenerator,
        )
    }

    private fun checkAmountPaid(amountPaid: Int) {
        require(amountPaid >= DEFAULT_LOTTO_PRICE) { INVALID_MIN_COST_LOTTO_PAID_MESSAGE }
        require(amountPaid % DEFAULT_LOTTO_PRICE == CHECK_SURPLUS) { INVALID_THOUSAND_UNIT_LOTTO_PAID_MESSAGE }
    }

    const val DEFAULT_LOTTO_PRICE: Int = 1000
    private const val CHECK_SURPLUS: Int = 0
    const val INVALID_MIN_COST_LOTTO_PAID_MESSAGE: String = "로또 구입 비용은 최소 1,000원 이상 이어야 합니다"
    const val INVALID_THOUSAND_UNIT_LOTTO_PAID_MESSAGE: String = "로또 구입 비용은 1,000원 단위로 지불해야 합니다"
}
