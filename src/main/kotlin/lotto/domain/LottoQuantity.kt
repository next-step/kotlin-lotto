package lotto.domain

@JvmInline
value class LottoQuantity(val value: Int) {
    init {
        validateValueIsPotivieZero()
    }

    private fun validateValueIsPotivieZero() {
        require(value >= 0) { "로또 수량 값은 0 이상이어야 합니다." }
    }

    operator fun compareTo(desiredLottoQuantity: LottoQuantity): Int {
        return value.compareTo(desiredLottoQuantity.value)
    }

    override fun toString(): String {
        return value.toString()
    }
}
