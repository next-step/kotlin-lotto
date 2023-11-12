
package lotto.domain

enum class LottoRank(val winningMoney: Int, val matchCount: Int) {
    FIRST(2_000_000_000, 6),
    SECOND_WITH_BONUS(30_000_000, 5),
    SECOND(1_500_000, 5),
    THIRD(50_000, 4),
    FOURTH(5_000, 3),
    MISS(0, 0);

    companion object {
        private fun findByMatchCount(matchCount: Int): LottoRank {
            return values().find { it.matchCount == matchCount } ?: MISS
        }

        fun Lotto.getLottoRank(winningLotto: Lotto, bonusNumber: Int): LottoRank {
            require(bonusNumber in Lotto.LOTTO_NUMBER_MIN..Lotto.LOTTO_NUMBER_MAX) { "보너스 번호는 1부터 45까지의 숫자만 가능합니다." }

            val matchCount: Int = this.getMatchCount(winningLotto)
            val lottoRank: LottoRank = findByMatchCount(matchCount)

            return if (matchCount == 5) {
                if (this.isContainsBonusNumber(bonusNumber)) SECOND_WITH_BONUS else SECOND
            } else {
                lottoRank
            }
        }
    }
}
