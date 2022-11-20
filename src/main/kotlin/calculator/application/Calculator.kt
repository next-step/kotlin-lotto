package calculator.application

interface Calculator : PlusOperation

sealed interface PlusOperation {
    fun plus(firstNumber: Int, secondNumber: Int): Int
}
