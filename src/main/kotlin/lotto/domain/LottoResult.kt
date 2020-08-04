package lotto.domain

enum class LottoResult(val matchCount: Int, val price: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    FIFTH(2, 0),
    SIX(1, 0),
    NONE(0, 0);
}

fun getPlace(count: Int): LottoResult {
    return when (count) {
        6 -> LottoResult.FIRST
        5 -> LottoResult.SECOND
        4 -> LottoResult.THIRD
        3 -> LottoResult.FOURTH
        2 -> LottoResult.FIFTH
        1 -> LottoResult.SIX
        else -> LottoResult.NONE
    }
}
