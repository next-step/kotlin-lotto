package stringaddcalculator.domain

fun main(input: String): Int {
    val numbers = NumbersGenerator(input).generate()
    return numbers.sum()
}
