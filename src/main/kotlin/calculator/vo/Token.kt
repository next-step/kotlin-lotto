package calculator.vo

const val DEFAULT_TOKEN_VALUE = 0

data class Token(val token: Int) {
    init {
        if (token < DEFAULT_TOKEN_VALUE)
            throw java.lang.RuntimeException("token은 0보다 작을 수 없습니다.")
    }

    companion object {
        fun of(str: String): Token {
            if (str.isBlank()) {
                return Token(DEFAULT_TOKEN_VALUE)
            }
            return Token(str.toIntOrNull() ?: throw RuntimeException("올바르지 않은 피연산자 타입입니다. token = [$str]"))
        }
    }
}
