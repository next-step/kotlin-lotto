package lotto.domain

@JvmInline
value class LottoMoney(
    val value: Int
) {
    init {
        validateMoney()
    }

    private fun validateMoney() {
        if (value <= MIN_VALUE) {
            throw IllegalArgumentException("로또 구입 금액은 0원 이상이어야 합니다.")
        }
    }

    fun calculateLottoCount(): Int {
        return value / PRICE
    }

    companion object {
        const val MIN_VALUE = 0
        const val PRICE = 1000
    }
}
