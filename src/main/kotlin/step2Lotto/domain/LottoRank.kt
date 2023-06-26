package step2Lotto.domain

enum class LottoRank(val prizeMoney: Int) {
    FIRST(2_000_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    LOSE(0)
}

fun getLottoRank(lotto: Lotto, winningNumber: WinningNumber): LottoRank {
    return when (lotto.numbers.intersect(winningNumber.numbers.toSet()).size) {
        3 -> LottoRank.FIFTH
        4 -> LottoRank.FOURTH
        5 -> LottoRank.THIRD
        6 -> LottoRank.FIRST
        else -> LottoRank.LOSE
    }
}
