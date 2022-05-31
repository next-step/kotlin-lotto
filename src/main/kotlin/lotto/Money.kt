package lotto

import java.math.BigDecimal

class Money(private val value: BigDecimal) {

    init {
        validate(value.intValueExact())
    }

    val won: Int
        get() = value.intValueExact()

    fun divide(value: Int): Money = Money(this.value.divide(BigDecimal(value)))

    private fun validate(value: Int) {
        if (value <= ZERO) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        private const val ZERO = 0
    }
}
