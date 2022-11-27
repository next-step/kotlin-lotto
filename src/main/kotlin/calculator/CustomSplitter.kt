package calculator

class CustomSplitter : Splitter {

    override fun split(text: String): List<String> {
        val matchResult = REGEX.find(text)
        require(matchResult != null) { "커스텀 구분자가 입력값에 존재하지 않습니다." }
        val customDelimiter = matchResult.groupValues[1]
        return matchResult.groupValues[2].split(customDelimiter)
    }

    companion object {
        private const val DELIMITER = "//(.)\n(.*)"

        private val REGEX = Regex(DELIMITER)
        fun containsSplitter(text: String): Boolean = REGEX.containsMatchIn(text)
    }
}
