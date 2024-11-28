package lotto.domain

class Match {
    companion object {
        fun lottoNumber(
            userLotto: Lotto,
            winningLotto: Lotto,
        ): Int {
            val lottoNumbers: Set<LottoNumber> = userLotto.lottoNumbers
            val winningLottoNumbers: Set<LottoNumber> = winningLotto.lottoNumbers

            val matchCount = lottoNumbers.filter { winningLottoNumbers.contains(it) }.size
            return rank(matchCount)
        }

        private fun rank(matchCount: Int): Int {
            return when (matchCount) {
                6 -> {
                    1
                }

                5 -> {
                    2
                }

                4 -> {
                    3
                }

                3 -> {
                    4
                }

                else -> 0
            }
        }
    }
}
