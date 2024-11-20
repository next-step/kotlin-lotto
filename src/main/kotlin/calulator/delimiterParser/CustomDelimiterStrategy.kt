package calulator.delimiterParser

class CustomDelimiterStrategy : DelimiterStrategy {
    override fun support(text: String): Boolean {
        val matchResult = Regex("//(.)\n(.*)").find(text)
        return matchResult != null
    }

    override fun parse(text: String): List<Int> {
        val matchResult = Regex("//(.)\n(.*)").find(text)
            ?: throw RuntimeException("잘못된 입력입니다.")

        val delimiter = matchResult.groupValues[1]
        val nums = matchResult.groupValues[2]

        return nums.split(delimiter).map { it.toInt() }
    }
}
