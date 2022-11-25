package calculator.application.calculator

import calculator.common.model.PositiveIntegers

interface Calculator : MultiplePlusOperation

sealed interface MultiplePlusOperation {
    fun multiplePlus(numbers: PositiveIntegers): Int
}
