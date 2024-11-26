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

    companion object {
        fun from(vararg lines: LottoLine): Lotto = Lotto(lines.toList())
    }
}
