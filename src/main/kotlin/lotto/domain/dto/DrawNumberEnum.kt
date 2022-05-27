package lotto.domain.dto

enum class DrawNumberEnum(val count: Int, val amount: Long) {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    NONE(0, 0);
}
