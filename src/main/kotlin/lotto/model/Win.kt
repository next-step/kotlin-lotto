package lotto.model

enum class Win(val matchNumber: Int, val matchBonusNumber: Int, val prize: Int) {
    NONE(0, 0, 0),
    FIFTH(3, 0, 5_000),
    FOURTH(4, 0, 50_000),
    THIRD(5, 0, 1_500_000),
    SECOND(5, 1, 30_000_000),
    FIRST(6, 0, 2_000_000_000);
}

fun getPrize(matchNumber: Int, matchBonusNumber: Int): Win {
    if (matchNumber == 3 && matchBonusNumber == 0) return Win.FIFTH
    if (matchNumber == 4 && matchBonusNumber == 0) return Win.FOURTH
    if (matchNumber == 5 && matchBonusNumber == 0) return Win.THIRD
    if (matchNumber == 5 && matchBonusNumber == 1) return Win.SECOND
    if (matchNumber == 6 && matchBonusNumber == 0) return Win.FIRST
    return Win.NONE
}
