package calculator

class StringAddCalculator {
    fun add(text: String): Int {
        if (text.isBlank()) return 0
        if (text.matches(Regex("[0-9]+"))) {
            return text.toInt()
        }

        val tokens = parseTokens(text)
        validateTokens(tokens)

        return tokens.sum()
    }

    private fun parseTokens(text: String): List<Int> {
        require(text.contains("-").not()) { "음수를 입력할 수 없습니다." }
        require(text.contains(Regex("[,:]"))) { "구분자 , 또는 : 를 포함해야 합니다." }
        return text.split(Regex("[,:\n]")).map { it.toInt() }
    }

    private fun validateTokens(tokens: List<Int>) {
        require(tokens.all { it >= 0 }) { "음수를 입력할 수 없습니다." }

    }
}
