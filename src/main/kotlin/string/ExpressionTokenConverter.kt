package string

class ExpressionTokenConverter {
    fun convert(token: String): Int {
        val numericParsedToken = token.toIntOrNull()
        if (numericParsedToken == null || numericParsedToken < 0) {
            throw RuntimeException("올바르지 않은 정수값(${numericParsedToken})입니다")
        }
        return numericParsedToken
    }
}