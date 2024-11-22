package lotto.domain

import lotto.domain.LottoBall.Companion.LOTTO_BALL_RANGE

class LottoBalls(private val balls: List<LottoBall>) {
    fun checkBallSize(size: Int) {
        require(balls.size == size) { "로또 번호는 ${size}개여야 합니다." }
    }

    fun checkIsUniqueBalls() {
        require(balls.toSet().size == balls.size) { "로또 번호는 중복되지 않아야 합니다." }
    }

    fun extractMatchCount(other: LottoBalls): Int {
        return balls.count { other.containsBall(it) }
    }

    private fun containsBall(ball: LottoBall): Boolean {
        return balls.contains(ball)
    }

    fun extractLottoNumbers(): List<Int> {
        return balls.map { it.ballNumber }
    }

    companion object {
        val LOTTO_BALLS: List<LottoBall> = LOTTO_BALL_RANGE.map { LottoBall(it) }
    }
}
