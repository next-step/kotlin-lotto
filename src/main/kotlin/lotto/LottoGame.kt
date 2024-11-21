package lotto

class LottoGame(private val lottoBalls: List<LottoBall>) {
    init {
        checkIsSixBalls()
        checkIsUniqueBalls()
    }

    private fun checkIsSixBalls() {
        require(lottoBalls.size == 6) { "로또 번호는 6개여야 합니다." }
    }

    private fun checkIsUniqueBalls() {
        require(lottoBalls.toSet().size == 6) { "로또 번호는 중복되지 않아야 합니다." }
    }
}
