package lotto.domain

class WinningLotto(
    private val lotto: Lotto,
    private val bonusNumber: BonusNumber,
) {
    init {
        require(bonusNumber.value !in lotto.numbers) {
            "보너스 번호는 당첨 번호와 중복될 수 없습니다."
        }
    }

    fun getRank(lottoToCompare: Lotto): Rank {
        val matchCount = lottoToCompare.intersect(lotto).size
        val matchBonus = bonusNumber in lottoToCompare
        return Rank.from(matchCount, matchBonus)
    }
}
