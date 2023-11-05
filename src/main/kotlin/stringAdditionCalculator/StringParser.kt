package stringAdditionCalculator

import java.lang.RuntimeException

class StringParser(private val separatorList: List<String>) {

    init {
        require(separatorList.all { it.isNotEmpty() }) { "구분자가 없습니다.\n빈 문자는 구분자가 될 수 없습니다. 스페이스 공백은 허용합니다." }
    }

    private fun parseable(input: String): Boolean = this.separatorList.any { input.contains(it) }

    fun parseToInt(input: String): List<Int> = parse(input).map { it.toInt() }

    fun parse(input: String): List<String> {
        require(parseable(input)) { "${this.separatorList.joinToString(", ")} 중 하나 이상의 구분자가 포함되어야 합니다." }

        val parseValue: List<String> = parse(input, this.separatorList)

        if (parseValue.any { it.toIntOrNull() == null || it.toInt() < 0 }) {
            throw RuntimeException("숫자가 아닌 값 또는 음수는 입력할 수 없습니다.")
        }

        return parseValue
    }

    private fun parse(input: String, separatorList: List<String>): List<String> {
        if (separatorList.size == 1) {
            return input.split(separatorList.first())
        }

        return parse(input, separatorList.drop(1)).flatMap { parse(it, listOf(separatorList.first())) }
    }
}
