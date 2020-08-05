package lotto.model

enum class Win(val matchNumber: Int, val matchBonusNumber: Int, val prize: Int) {
    NONE(0, 0, 0),
    FIFTH(3, 0, 5_000),
    FOURTH(4, 0, 50_000),
    THIRD(5, 0, 1_500_000),
    SECOND(5, 1, 30_000_000),
    FIRST(6, 0, 2_000_000_000);
}

fun getPrize(matchNumber: Int, matchBonus: Boolean): Win {
    if (matchNumber == 3 && !matchBonus) return Win.FIFTH
    if (matchNumber == 4 && !matchBonus) return Win.FOURTH
    if (matchNumber == 5 && !matchBonus) return Win.THIRD
    if (matchNumber == 5 && matchBonus) return Win.SECOND
    if (matchNumber == 6 && !matchBonus) return Win.FIRST
    return Win.NONE
}
