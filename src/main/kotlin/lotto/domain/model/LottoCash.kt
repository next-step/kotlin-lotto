package lotto.domain.model

@JvmInline
value class LottoCash private constructor(val value: Int) {

    companion object {
        fun valueOf(value: Int): LottoCash {
            require(value >= 0) {
                "숫자는 음수일 수 없습니다."
            }
            return LottoCash(value)
        }
    }
}
