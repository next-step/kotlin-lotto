package lotto

import java.math.BigDecimal

data class Money(private val _value: BigDecimal) {

    init {
        validate(_value.intValueExact())
    }

    val get: Int
        get() = _value.intValueExact()

    private fun validate(value: Int) {
        if (value <= 0) {
            throw IllegalArgumentException()
        }
    }
}
