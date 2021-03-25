package lotto

enum class LottoRank(val matchCount: Int, val prizeMoney: Int, val rank: Int) {

    FIRST(6, 2000000000, 1),
    SECOND(5, 30000000, 2),
    THIRD(5, 1500000, 3),
    FOURTH(4, 50000, 4),
    FIFTH(3, 5000, 5),
    NONE(0, 0, 6);

    companion object {

        fun matchRank(winnerNumber: WinnerNumber, lottoNumber: LottoNumber): LottoRank {
            val matchCount = lottoNumber.numbers.filter {
                number ->
                winnerNumber.winnerNumbers.contains(number)
            }.size
            val matchBonus = lottoNumber.numbers.contains(winnerNumber.bonusNumber)
            return valueOf(matchCount, matchBonus)
        }

        private fun valueOf(matchCount: Int, matchBonus: Boolean): LottoRank {
            if (FIRST.matchCount == matchCount) return FIRST

            if (SECOND.matchCount == matchCount && matchBonus) return SECOND

            return values()
                .filter { it.rank > 2 }
                .find { it.matchCount == matchCount } ?: NONE
        }
    }
}
