package lotto.domain

class LottoLine(private val lottoBalls: List<LottoBall>) {
    constructor(lottoInput: String) : this(lottoInput.split(",").map { LottoBall(it.trim().toInt()) })

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

    fun extractMatchCount(other: LottoLine): Int {
        return lottoBalls.count { other.lottoBalls.contains(it) }
    }

    fun extractLottoNumbers(): List<Int> {
        return lottoBalls.map { it.ballNumber }
    }
}
