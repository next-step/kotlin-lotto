package lotto.domain

class PurchaseAmount(input: String) {
    val amount: Int

    init {
        val amount = input.toInt()
        validateNegative(amount)
        this.amount = amount
    }

    operator fun div(lottoPrice: LottoPrice): Int = amount / lottoPrice.price

    private fun validateNegative(amount: Int) {
        require(amount >= 0) { "구입할 금액은 음수가 될 수 없습니다." }
    }
}
