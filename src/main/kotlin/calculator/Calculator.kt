package calculator

import java.math.BigDecimal

object Calculator {
    fun sum(numberList: List<BigDecimal>): BigDecimal =
        numberList.sumOf { number ->
            if (number < BigDecimal.ZERO) throw RuntimeException("$number ${MessageCode.NegativeException.message}")
            number
        }
}
