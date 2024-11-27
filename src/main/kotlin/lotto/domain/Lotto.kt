package lotto.domain

class Lotto(
    val lines: List<LottoLine>,
) {
    val numberOfLines: Int
        get() = lines.size

    fun match(winner: WinningLine): LottoResult {
        val rankToCount =
            lines
                .groupBy { it.match(winner) }
                .mapValues { (_, value) -> value.size }
        return LottoResult.from(rankToCount)
    }

    fun match2(winner: WinningLine): LottoResult2 {
        val rankToCount =
            lines
                .groupBy { it.match2(winner) }
                .mapValues { (_, value) -> value.size }
        return LottoResult2.from(rankToCount)
    }

    fun merge(lotto: Lotto): Lotto = Lotto(lines + lotto.lines)

    companion object {
        fun from(vararg lines: LottoLine): Lotto = Lotto(lines.toList())
    }
}
