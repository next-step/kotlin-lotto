package calculator

import java.math.BigDecimal

class StringAddCalculator {
    fun add(text: String?): BigDecimal? =
        StringInput.stringToBigDecimalList(text)?.let { numbers ->
            Calculator.sum(numbers)
        }
}
