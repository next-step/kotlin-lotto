package calculator.stringcalculator.splitter

fun interface Splitter<T, R> {
    fun split(input: T): R
}
