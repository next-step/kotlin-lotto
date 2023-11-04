package calculator.model

data class Token(
    val value: Int,
) {

    init {
        require(value >= 0) { "0과 양수만 허용됩니다 [$value]는 허용되지 않습니다" }
    }

    fun add(token: Token): Token {
        return this.copy(value = this.value + token.value)
    }
}
