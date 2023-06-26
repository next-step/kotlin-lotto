package step2Lotto.domain

enum class LottoRank(val prizeMoney: Int) {
    FIRST(2000000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    LOSE(0)
}

fun getLottoRank(lotto: Lotto, winningNumber: Lotto): LottoRank {
    return when (lotto.numbers.intersect(winningNumber.numbers.toSet()).size) {
        3 -> LottoRank.FIFTH
        4 -> LottoRank.FOURTH
        5 -> LottoRank.THIRD
        6 -> LottoRank.FIRST
        else -> LottoRank.LOSE
    }
}
