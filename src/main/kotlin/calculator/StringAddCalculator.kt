package calculator

class StringAddCalculator {

    private fun String.toInt(): Int {
        val number = Integer.parseInt(this)
        require(number >= 0) {"음수는 입력할 수 없습니다."}
        return number
    }

    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        try {
            return text.toInt()
        } catch (_: Exception) {
        }

        val result = Regex("//(.)\n(.*)").find(text)
        val delimiter = result?.groupValues?.get(1)

        val standardDelimiter = Regex("[,:]")

        if (delimiter.isNullOrEmpty()) {
            return text.split(standardDelimiter).sumOf { it.toInt() }
        } else {
            val tokens = result.groupValues.get(2).split(delimiter)
            return tokens.sumOf { it.toInt() }
        }
    }

}
