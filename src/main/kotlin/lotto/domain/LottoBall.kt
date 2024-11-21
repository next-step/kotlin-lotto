package lotto.domain

@JvmInline
value class LottoBall(val ballNumber: Int) {
    init {
        checkIsInValidRange()
    }

    private fun checkIsInValidRange() {
        require(ballNumber in LOTTO_BALL_RANGE) { "로또 번호는 1부터 45 사이여야 합니다." }
    }

    companion object {
        private val LOTTO_BALL_RANGE = 1..45
    }
}
