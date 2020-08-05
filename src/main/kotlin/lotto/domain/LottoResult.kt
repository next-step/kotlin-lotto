package lotto.domain

enum class LottoResult(val matchCount: Int, val price: Int, val isBonus: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND_BONUS(5, 30_000_000, true),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    FIFTH(2, 0),
    SIX(1, 0),
    NONE(0, 0);
}

fun getPlace(count: Int, isBonus: Boolean): LottoResult {
    return when (count) {
        6 -> LottoResult.FIRST
        5 -> checkSecond(isBonus)
        4 -> LottoResult.THIRD
        3 -> LottoResult.FOURTH
        2 -> LottoResult.FIFTH
        1 -> LottoResult.SIX
        else -> LottoResult.NONE
    }
}

private fun checkSecond(isBonus: Boolean): LottoResult {
    return if (isBonus) {
        LottoResult.SECOND_BONUS
    } else {
        LottoResult.SECOND
    }
}
