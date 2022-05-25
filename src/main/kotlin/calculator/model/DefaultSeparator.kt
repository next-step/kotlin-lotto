package calculator.model

object DefaultSeparator : Separable {
    private val INPUT_PATTERN = "(.)([:|,](.))*".toRegex()
    private val DEFAULT_DELIMITER_REGEX = "[,:]".toRegex()

    override fun isSeparable(input: String) = INPUT_PATTERN.matches(input)

    override fun separate(input: String): List<String> {
        require(isSeparable(input)) { "기본 인풋 패턴과 매치되지 않습니다. (input: $input)" }

        return input.split(DEFAULT_DELIMITER_REGEX)
    }
}
