package stringAddCalculator

object Tokenizer {
    fun tokenize(text: String?): List<String> {
        if (text.isNullOrBlank()) {
            return listOf("0")
        }
        return Separator.separateByCustomDelimiter(text) ?: Separator.separate(text)
    }

    fun validate(tokens: List<String>) {
        tokens.all {
            require(it.trim().toIntOrNull() != null) {
                "구분자를 제외한 입력값은 숫자여야 합니다."
            }
            require(it.trim().toInt() >= 0) {
                "음수는 입력할 수 없습니다."
            }
            true
        }
    }
}
