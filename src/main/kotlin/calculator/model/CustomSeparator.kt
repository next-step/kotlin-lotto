package calculator.model

object CustomSeparator : SepartorStrategy {
    private val INPUT_PATTERN = "//(.)\n(.*)".toRegex()

    override fun isSeparable(input: String) = INPUT_PATTERN.matches(input)

    override fun separate(input: String): List<String> {
        require(isSeparable(input)) { "사용자 정의 인풋 패턴과 매치되지 않습니다. (input: $input)" }

        val delimiterAndTokens = INPUT_PATTERN.find(input)!!
        val delimiter = delimiterAndTokens.groupValues[1].toRegex()
        val tokens = delimiterAndTokens.groupValues[2]

        return tokens.split(delimiter)
    }
}
