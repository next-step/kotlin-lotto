package calculator.usecase

interface Parser {
    fun parse(input: String): List<Int>
}
