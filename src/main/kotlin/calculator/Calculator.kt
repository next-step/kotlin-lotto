package calculator

class Calculator(private val input: String) {

    private fun isNegative(value: Int) = value < 0

    private fun tokens(): List<String> {
        val result = Regex("//(.)\n(.*)").find(input)
        result?.let {
            val delimiter = it.groupValues[1]
            return it.groupValues[2].split(delimiter)
        } ?: run {
            return input.split(":", ",")
        }
    }

    private fun operator(acc: Int, value: Int): Int {
        if (isNegative(value)) {
            throw RuntimeException("양수만 입력해주세요.")
        }

        return acc + value
    }

    private fun toInt(value: String): Int {
        return value.toIntOrNull()
            ?: throw RuntimeException("숫자 또는 구분자만 입력해주세요.")
    }

    fun sum(): Int {
        return tokens()
            .filter { it.isNotBlank() }
            .map { toInt(it) }
            .fold(0) { acc: Int, it: Int -> operator(acc, it) }
    }
}