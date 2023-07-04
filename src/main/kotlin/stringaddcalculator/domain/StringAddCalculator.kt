package stringaddcalculator.domain

fun main(input: String): Int {
    val numbers = NumbersGenerator().generate(input)
    return numbers.sum()
}
