package lotto.domain.dto

enum class Rank(val count: Int, val amount: Long) {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000),
    NONE(0, 0);
}
