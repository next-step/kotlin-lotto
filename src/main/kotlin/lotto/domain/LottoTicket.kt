package lotto.domain

data class LottoTicket(
    val lottoNumbers: List<Int>
) {
    init {
        require(lottoNumbers.size == LOTTO_SIZE) { "로또 번호는 6개로 구성되어야 해요" }
    }

    fun match(winningLotto: WinningNumber, bonusNumber: BonusNumber): Rank {
        val matchCount = count(winningLotto)
        val matchBonus = contains(bonusNumber)
        return rank(matchCount, matchBonus)
    }

    private fun rank(matchCount: Int, matchBonus: Boolean): Rank {
        return if (matchCount == 5 && matchBonus) {
            Rank.SECOND
        } else if (matchCount == 5) {
            Rank.THIRD
        } else {
            Rank.of(matchCount)
        }
    }

    private fun count(winningNumber: WinningNumber): Int {
        return lottoNumbers.count(winningNumber::hasNumber)
    }

    private fun contains(bonusNumber: BonusNumber): Boolean {
        return lottoNumbers.contains(bonusNumber.bonusNumber)
    }

    companion object {
        const val LOTTO_SIZE = 6
    }
}
