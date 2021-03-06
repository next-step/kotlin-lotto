package stringcalculator.model

class StringCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return 0
        }

        val result = Regex("//(.)\\\\n(.*)").find(input)

        val splitInputs = if (result != null) {
            val customDelimiter = result.groupValues[1]
            result.groupValues[2].split(customDelimiter)
        } else {
            input.split(",").map { it.split(":") }.flatten()
        }

        splitInputs.forEach {
            require(it.toIntOrNull() != null && it.toInt() >= 0) { "문자열 계산기에는 0, 양수만 인자로 올 수 있습니다!" }
        }

        return splitInputs.map { it.toInt() }.reduce { acc, i -> acc + i }
    }
}
