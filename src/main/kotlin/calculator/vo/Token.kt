package calculator.vo

const val DEFAULT_TOKEN_VALUE = 0

data class Token(val token: Int = DEFAULT_TOKEN_VALUE) {
    init {
        if (token < DEFAULT_TOKEN_VALUE)
            throw java.lang.RuntimeException("token은 0보다 작을 수 없습니다.")
    }
}
