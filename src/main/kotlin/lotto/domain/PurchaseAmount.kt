package lotto.domain

class PurchaseAmount(input: String) {
    val amount: Int

    init {
        val amount = input.toInt()
        validateNegative(amount)
        validateUnit(amount)
        this.amount = amount
    }

    private fun validateUnit(amount: Int) {
        require(amount / 1000 == 0) { "구입할 금액은 천원 단위로 입력할 수 있습니다." }
    }

    private fun validateNegative(amount: Int) {
        require(amount >= 0) { "구입할 금액은 음수가 될 수 없습니다." }
    }
}