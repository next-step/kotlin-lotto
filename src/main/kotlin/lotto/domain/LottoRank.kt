package lotto.domain

enum class LottoRank(val containCount: Int, val money: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun of(winningNumbers: WinningNumbers, lottoNumbers: LottoNumbers): LottoRank =
            when (getMatchingCount(winningNumbers.winningNumbers, lottoNumbers)) {
                3 -> FIFTH
                4 -> FOURTH
                5 -> {
                    if (isBonusMatched(lottoNumbers, winningNumbers.bonusNumber)) SECOND
                    else THIRD
                }

                6 -> FIRST
                else -> NONE
            }

        private fun getMatchingCount(winningNumbers: LottoNumbers, lottoNumbers: LottoNumbers): Int {
            return lottoNumbers.numbers.intersect(winningNumbers.numbers.toSet()).size
        }

        private fun isBonusMatched(lottoNumbers: LottoNumbers, bonusNumber: LottoNumber): Boolean {
            return lottoNumbers.numbers.contains(bonusNumber)
        }
    }
}
