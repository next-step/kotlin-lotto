package lotto.domain

enum class LottoRank(val containCount: Int, val money: Int) {
    FIRST(6, 2_000_000_000) {
        override fun isMatch(matchingCount: Int, isBonusMatched: Boolean): Boolean =
            matchingCount == 6
    },
    SECOND(5, 30_000_000) {
        override fun isMatch(matchingCount: Int, isBonusMatched: Boolean): Boolean =
            matchingCount == 5 && isBonusMatched
    },
    THIRD(5, 1_500_000) {
        override fun isMatch(matchingCount: Int, isBonusMatched: Boolean): Boolean =
            matchingCount == 5 && !isBonusMatched
    },
    FOURTH(4, 50_000) {
        override fun isMatch(matchingCount: Int, isBonusMatched: Boolean): Boolean =
            matchingCount == 4
    },
    FIFTH(3, 5_000) {
        override fun isMatch(matchingCount: Int, isBonusMatched: Boolean): Boolean =
            matchingCount == 3
    },
    NONE(0, 0) {
        override fun isMatch(matchingCount: Int, isBonusMatched: Boolean): Boolean = false
    };

    abstract fun isMatch(matchingCount: Int, isBonusMatched: Boolean): Boolean

    companion object {
        fun of(winningNumbers: WinningNumbers, lottoNumbers: LottoNumbers): LottoRank {
            return LottoRank.values().find {
                it.isMatch(
                    getMatchingCount(winningNumbers.winningNumbers, lottoNumbers),
                    isBonusMatched(lottoNumbers, winningNumbers.bonusNumber)
                )
            } ?: NONE
        }

        private fun getMatchingCount(winningNumbers: LottoNumbers, lottoNumbers: LottoNumbers): Int {
            return lottoNumbers.numbers.intersect(winningNumbers.numbers.toSet()).size
        }

        private fun isBonusMatched(lottoNumbers: LottoNumbers, bonusNumber: LottoNumber): Boolean {
            return lottoNumbers.numbers.contains(bonusNumber)
        }
    }
}
