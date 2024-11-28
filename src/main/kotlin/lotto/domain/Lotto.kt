package lotto.domain

class Lotto(
    val lines: List<LottoLine>,
) {
    val numberOfLines: Int
        get() = lines.size

    fun match(winner: WinningLine): MatchResult {
        val rankToCount =
            lines
                .groupBy { it.match(winner) }
                .mapValues { (_, value) -> value.size }
        return MatchResult.from(rankToCount)
    }

    fun merge(lotto: Lotto): Lotto = Lotto(lines + lotto.lines)

    companion object {
        fun from(vararg lines: LottoLine): Lotto = Lotto(lines.toList())

        fun from(lines: List<List<Int>>): Lotto = Lotto(lines.map(LottoLine::from))
    }
}
