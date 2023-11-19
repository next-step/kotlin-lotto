package lotto

enum class LottoPrize(val matchCount: Int, val prizeMoney: Int) {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    companion object {
        private fun getMatchingCount(winningNumbers: Lotto, lottoNumbers: Lotto): Int {
            return lottoNumbers.lottoNumbers.intersect(winningNumbers.lottoNumbers.toSet()).size
        }

        private fun isBonusMatched(lottoNumbers: Lotto, bonusNumber: LottoNumber): Boolean {
            return lottoNumbers.lottoNumbers.contains(bonusNumber)
        }
        fun of(winningLotto: WinningLotto, lottoNumbers: Lotto): LottoPrize =
            when (getMatchingCount(winningLotto.winningNumber, lottoNumbers)) {
                3 -> FIFTH
                4 -> FOURTH
                5 -> {
                    if (isBonusMatched(lottoNumbers, winningLotto.bonusNumber)) SECOND
                    else THIRD
                }

                6 -> FIRST
                else -> MISS
            }

    }
}
