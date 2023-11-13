package lotto.domain

@JvmInline
value class LottoCash private constructor(val value: Int) {

    companion object {
        fun valueOf(value: String): LottoCash {
            require(value.toIntOrNull() != null) {
                "숫자 이외의 값일 수 없습니다."
            }
            require(value.toInt() >= 0) {
                "숫자는 음수일 수 없습니다."
            }
            return LottoCash(value.toInt())
        }
    }
}
