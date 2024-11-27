package lotto.domain

class LottoLine(
    val numbers: List<LottoNumber>,
) {
    init {
        require(numbers.size == LINE_SIZE) { "로또 번호는 ${LINE_SIZE}개여야 합니다." }
        require(numbers.distinct().size == LINE_SIZE) { "로또 번호는 중복되지 않아야 합니다." }
    }

    fun contains(number: LottoNumber): Boolean = numbers.contains(number)

    fun countOverlap(other: LottoLine): Int = numbers.count { other.contains(it) }

    fun match2(winner: WinningLine): Rank2 =
        Rank2.valueOf(
            MatchStats(
                countOverlap(winner.line),
                contains(winner.bonus),
            ),
        )

    companion object {
        const val LINE_SIZE = 6

        fun from(values: List<Int>): LottoLine = LottoLine(values.map { LottoNumber.from(it) }.sorted())

        fun from(vararg values: Int): LottoLine = from(values.toList())
    }
}
