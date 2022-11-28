package caculator.domain

class Numbers(
    private val numbers: List<Int>,
) {

    init {
        if (numbers.any { it < 0 }) throw RuntimeException("잘못된 입력입니다. 양수만 입력해주세요.")
    }

    companion object {
        operator fun invoke(numbers: List<String>): Numbers =
            numbers.map { it.toIntOrNull() ?: throw RuntimeException("잘못된 입력입니다. 숫자만 입력해주세요.") }
                .let(::Numbers)
    }
}
