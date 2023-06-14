package calculator

class Calculator(text: String) {

    val separator: String
    val numbers: List<Int>

    init {
        when {
            text.isNullOrBlank() -> {
                separator = ""
                numbers = listOf()
            }
            text.contains("//") && text.contains("\n") -> {
                val result = Regex("(?<=//).|(?<=\\\n).*").findAll(text).map { it.value.trim() }.toList()
                separator = result[0]
                numbers = result[1].split(separator).map { it.toInt() }
            }
            text.contains(",") -> {
                separator = ","
                numbers = text.split(separator).map { it.toInt() }
            }
            text.contains(":") -> {
                separator = ":"
                numbers = text.split(separator).map { it.toInt() }
            }
            else -> throw IllegalArgumentException("잘못된 구분자를 입력하셨습니다.")
        }
    }

    val result = numbers.sum()
}