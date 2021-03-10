package stringcalculator

class Number(valueString: String) {
    val value: Int

    init {
        val candidate = valueString.toIntOrNull()
        require(candidate != null && candidate >= 0) { "문자열 계산기에는 0, 양수만 인자로 올 수 있습니다!" }
        value = candidate
    }
}
