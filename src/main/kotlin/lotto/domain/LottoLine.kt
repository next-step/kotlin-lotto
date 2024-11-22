package lotto.domain

class LottoLine(private val lottoBalls: List<LottoBall>) {
    init {
        checkIsSixBalls()
        checkIsUniqueBalls()
    }

    private fun checkIsSixBalls() {
        require(lottoBalls.size == LOTTO_BALLS_SIZE) { "로또 번호는 6개여야 합니다." }
    }

    private fun checkIsUniqueBalls() {
        require(lottoBalls.toSet().size == LOTTO_BALLS_SIZE) { "로또 번호는 중복되지 않아야 합니다." }
    }

    fun extractMatchCount(other: LottoLine): Int {
        return lottoBalls.count { other.containsBall(it) }
    }

    private fun containsBall(ball: LottoBall): Boolean {
        return lottoBalls.contains(ball)
    }

    fun extractLottoNumbers(): List<Int> {
        return lottoBalls.map { it.ballNumber }
    }

    companion object {
        private const val LOTTO_BALLS_SIZE = 6

        fun makeNewLottoLine(lottoInput: String): LottoLine {
            val lottoBalls = lottoInput.split(",").map { LottoBall(it.trim().toInt()) }
            return LottoLine(lottoBalls)
        }
    }
}
