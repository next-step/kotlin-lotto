package study

class StringAddCalculator {
    /**
     * //와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다`
     * 문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.
     */
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val tokens: List<String>
        if (text.startsWith("//")) {
            val result = Regex("//(.)\n(.*)").find(text)
            val divider = result?.groupValues?.get(1)
            tokens = result?.groupValues?.get(2)?.split(divider!!)!!
        } else {
            tokens = text.split("[,:]".toRegex())
        }

        return tokens
            .filter { it.isNotBlank() }
            .map { PositiveNumber(it) }
            .sumOf { it.value }
    }
}
