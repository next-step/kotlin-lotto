package lotto.domain

data class WinningLotto(private val lotto: Lotto, private val bonusNumber: LottoNumber) {
    init {
        require(!lotto.contains(bonusNumber)) { "보너스 숫자는 로또 당첨번호와 중복될 수 없습니다." }
    }

    fun match(other: Lotto): Rank {
        val equalCount = calculateEqualCount(other)
        val isBonusMatch = checkBonusMatch(other)

        return Rank.of(Score(equalCount, isBonusMatch))
    }

    private fun calculateEqualCount(other: Lotto): Int {
        return lotto.intersect(other)
    }

    private fun checkBonusMatch(other: Lotto): Boolean {
        return other.contains(bonusNumber)
    }
}
