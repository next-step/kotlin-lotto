package lotto.domain.value

class Money(private val won: Int) {
    init {
        if (won < ZERO) throw IllegalArgumentException("음수는 Money로 사용될 수 없습니다.")
    }

    companion object {
        private const val ZERO = 0
    }
}
