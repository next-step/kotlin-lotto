package lotto.domain

class WinningLotto(
    private val lotto: Lotto,
    private val bonusNumber: LottoNumber
) {

    init {
        require(!lotto.contains(bonusNumber)) { "우승 로또는 유일한 숫자로 구성되어야 합니다." }
    }

    fun judge(other: Lotto): Rank {
        val matchedCount = other.matchedCount(lotto)
        val hasBonusNumber = other.contains(bonusNumber)
        return Rank.find(matchedCount, hasBonusNumber)
    }
}
