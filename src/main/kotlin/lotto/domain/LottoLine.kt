package lotto.domain

class LottoLine(private val lottoBalls: LottoBalls) {
    constructor(balls: List<LottoBall>) : this(LottoBalls(balls))

    init {
        lottoBalls.checkBallSize(LOTTO_BALLS_SIZE)
        lottoBalls.checkIsUniqueBalls()
    }

    fun containBonusBall(bonusBall: LottoBall): Boolean {
        return lottoBalls.contains(bonusBall)
    }

    fun extractMatchCount(other: LottoLine): Int {
        return lottoBalls.extractMatchCount(other.lottoBalls)
    }

    fun extractLottoNumbers(): List<Int> {
        return lottoBalls.extractLottoNumbers()
    }

    companion object {
        const val LOTTO_BALLS_SIZE = 6

        fun makeNewLottoLine(lottoNumbers: List<Int>): LottoLine {
            return LottoLine(lottoNumbers.map { LottoBall(it) })
        }
    }
}
