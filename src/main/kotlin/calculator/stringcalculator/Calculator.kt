package calculator.stringcalculator

fun interface Calculator<T, R> {
    fun calculate(input: T): R
}
