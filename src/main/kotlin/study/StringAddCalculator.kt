package study

class StringAddCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        // 커스텀 구분자 있는지 확인
        val result = Regex("//(.)\n(.*)").find(input)
        result?.let {
            val customDelimiter = it.groupValues[1]
            val tokens = it.groupValues[2].split(customDelimiter)
            return add(tokens)
        } 

        val tokens = input.split(",|:".toRegex())
        return add(tokens)
    }
    
    private fun add(numbers: List<String>): Int {
        return numbers.map { it.toInt() }
            .filter {
                if (it > -1) true
                else throw RuntimeException() }
            .reduce { total, num -> total + num }
    }
}
