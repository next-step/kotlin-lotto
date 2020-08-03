package lotto.model

enum class Win(val matchNumber: Int, val prize: Int) {
    NONE(0, 0),
    SIXTH(1, 0),
    FIFTH(2, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);
}

fun getPrize(matchNumber: Int): Win {
    if (matchNumber == 3) return Win.FOURTH
    if (matchNumber == 4) return Win.THIRD
    if (matchNumber == 5) return Win.SECOND
    if (matchNumber == 6) return Win.FIRST
    return Win.NONE
}
