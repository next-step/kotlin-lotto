package calculator.application.calculator

import calculator.common.PositiveInteger

interface Calculator : MultiplePlusOperation

sealed interface MultiplePlusOperation {
    fun multiplePlus(numbers: List<PositiveInteger>): Int
}
