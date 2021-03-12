package lotto

class Ranking(private val winningNumbers: WinningNumbers, private val lottoNumbers: LottoNumbers) {
    fun rank(): Rank {
        val match = winningNumbers.match(lottoNumbers)
        if (Rank.FIRST.same(match)) {
            return Rank.FIRST
        }

        if (Rank.SECOND.same(match) &&
            winningNumbers.matchBonus(lottoNumbers)
        ) {
            return Rank.SECOND
        }

        return Rank.of(match)
    }

    enum class Rank(val match: Match = Match(), val amount: Long = 0) {
        FIFTH(Match(3), 5_000L),
        FOURTH(Match(4), 50_000L),
        THIRD(Match(5), 1_500_000L),
        SECOND(Match(5), 30_000_000L),
        FIRST(Match(6), 2_000_000_000L),
        MISS;

        fun prize(count: Int): Money = Money(amount * count)

        fun same(match: Match): Boolean = match == this.match

        companion object {
            fun of(match: Match): Rank = values().firstOrNull { it.same(match) } ?: MISS
        }
    }
}
