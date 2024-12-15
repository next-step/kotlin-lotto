package lotto.domain

@JvmInline
value class LottoAmount(private val value: Long) : Comparable<LottoAmount> {
    init {
        if (isInValidAmount(value)) {
            throw InvalidAmountException(value)
        }
    }

    private fun isInValidAmount(money: Long) = money % MIN_UNIT != 0L

    fun validatePurchasable(purchaseCount: Int) {
        val purchaseAmount = purchaseCount * MIN_UNIT
        if (purchaseAmount > value) {
            throw NotEnoughAmountException(purchaseCount)
        }
    }

    fun calculatePurchasableLottoCount(): Long {
        return value / MIN_UNIT
    }

    operator fun plus(other: LottoAmount): LottoAmount {
        return LottoAmount(this.value + other.value)
    }

    operator fun times(number: Int): LottoAmount {
        return LottoAmount(this.value * number)
    }

    operator fun div(other: LottoAmount): Double {
        return this.value / other.value.toDouble()
    }

    override fun compareTo(other: LottoAmount): Int {
        return this.value.compareTo(other.value)
    }

    override fun toString(): String {
        return value.toString()
    }

    companion object {
        const val MIN_UNIT = 1000L

        fun fromLottoCount(lottoCount: Int): LottoAmount {
            return LottoAmount(lottoCount * MIN_UNIT)
        }
    }
}
