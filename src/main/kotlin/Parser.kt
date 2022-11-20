import java.lang.IllegalArgumentException

class Parser() {
    fun parse(input: String): List<Int> {
        if (input.isNullOrEmpty()) {
            return listOf(0)
        }

        if (input.first() != '/') {
            return convertTo(input.split(",|:".toRegex()))
        }
        val result = Regex("//(.)\n(.*)").find(input)
        result?.let {
            val customDelimiter = it.groupValues[1]
            return convertTo(it.groupValues[2].split(customDelimiter))
        }
        throw IllegalArgumentException("잘못된 연산자 입력")
    }

    private fun convertTo(strList: List<String>): List<Int> {
        val result = mutableListOf<Int>()
        strList.forEachIndexed { _, s ->
            result.add(s.toInt())
        }
        return result
    }
}