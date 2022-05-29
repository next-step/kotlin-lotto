package lotto

import java.math.BigDecimal

class Money(private val _value: BigDecimal) {

    init {
        validate(_value.intValueExact())
    }

    val get: Int
        get() = _value.intValueExact()

    fun divide(value: Int): Money = Money(_value.divide(BigDecimal(value)))

    private fun validate(value: Int) {
        if (value <= 0) {
            throw IllegalArgumentException()
        }
    }
}
