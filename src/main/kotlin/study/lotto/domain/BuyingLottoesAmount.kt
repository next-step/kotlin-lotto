package study.lotto.domain

class BuyingLottoesAmount(
    purchasePriceAmount: Amount,
) {
    val amount = purchasePriceAmount / PRICE_PER_TICKET

    fun getSpentAmount() = Amount(this.amount * PRICE_PER_TICKET)

    companion object {
        const val PRICE_PER_TICKET = 1_000

        fun get(lottoCount: Amount) = BuyingLottoesAmount(Amount(lottoCount * PRICE_PER_TICKET))
    }
}
