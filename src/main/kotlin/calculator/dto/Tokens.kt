package calculator.dto

@JvmInline
value class Token(val value: String) {

    /**
     * 객체 생성시, 입력값이 0 이상인 양의 정수인지 검증한다.
     * - 음수가 입력되는 runtime exception 발생 시킨다.
     * */
    init {
        require(value.toInt() >= 0) { "음수는 입력할 수 없습니다." }
    }
}

data class Tokens(val tokens: List<Token>) {
    fun sum(): Int {
        return tokens.sumOf { it.value.toInt() }
    }
}
