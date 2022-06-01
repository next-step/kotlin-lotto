package calculator

class StringCalculator {
    fun add(text: String): Int {
        if (text.isEmpty()) {
            return 0
        }

        if (text.toIntOrNull() != null) {
            return text.toInt()
        }

        return text
            .split("[,:]".toRegex())
            .sumOf {
                it.toIntOrNull() ?: throw IllegalArgumentException("계산할 값은 정수로 입력해야합니다. text: $text")
            }
    }
}
