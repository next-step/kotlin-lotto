package calculator.stringcalculator.splitter

interface Splitter<T, R> {
    fun supported(input: T): Boolean
    fun split(input: T): R
}
