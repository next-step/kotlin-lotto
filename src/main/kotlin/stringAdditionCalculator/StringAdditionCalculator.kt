package stringAdditionCalculator

fun main() {
    val input: String = readlnOrNull() ?: throw IllegalArgumentException("입력 값이 없습니다.")

    val customSeparatorList: List<String> = SeparatorParser().extractCustomSeparatorList(input)

    val stringParser: StringParser = StringParser(customSeparatorList)

    val inputWithoutCustomSeparator: String = SeparatorParser().getWithoutCustomSeparator(input)
    val result: Int = AdditionCalculator(stringParser).calculate(inputWithoutCustomSeparator)
    println(result)
}
