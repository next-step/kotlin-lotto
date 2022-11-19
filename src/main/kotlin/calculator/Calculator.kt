package calculator

class Calculator {
    fun calculate(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val tokens = separateByDelimiter(text)
        val numbers = parseToInt(tokens)

        if(hasNegativeNumber(numbers)){
            throw RuntimeException("계산기에 음수는 입력할 수 없습니다.")
        }

        return numbers.sum()
    }

    private fun separateByDelimiter(text: String): List<String> {
        val result = Regex("//(.)\n(.*)").find(text)
        result?.let {
            val customDelimiter = it.groupValues[1]

            return it.groupValues[2]
                .split(customDelimiter)

        }

        return text.split("[,:]".toRegex())
    }

    private fun hasNegativeNumber(numbers: List<Int>): Boolean {
        return numbers.any { number -> number < 0 }
    }

    private fun parseToInt(numbers: List<String>): List<Int> {
        if(numbers.any { number -> number.toIntOrNull() === null }){
            throw RuntimeException("계산기에 숫자가 아닌 값은 입력할 수 없습니다")
        }

        return numbers.map{
            token -> token.toInt()
        }
    }
}
