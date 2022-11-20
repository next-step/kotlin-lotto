package calculator.application

interface Calculator : MultiplePlusOperation

sealed interface MultiplePlusOperation {
    fun multiplePlus(vararg numbers: Int): Int
}
