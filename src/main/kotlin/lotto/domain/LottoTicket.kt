package lotto.domain

data class LottoTicket(
    val lottoNumbers: List<Int>
) {
    init {
        require(lottoNumbers.size == LOTTO_SIZE) { "로또 번호는 6개로 구성되어야 해요" }
    }

    fun match(winningNumbers: WinningLotto, bonusNumber: BonusNumber): Rank {
        val matchCount = count(winningNumbers)
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

    private fun count(winningNumbers: WinningLotto): Int {
        return lottoNumbers.count(winningNumbers::hasNumber)
    }

    private fun contains(bonusNumber: BonusNumber): Boolean {
        return lottoNumbers.contains(bonusNumber.bonusNumber)
    }

    companion object {
        const val LOTTO_SIZE = 6
    }
}
