package lotto.domain.enums

enum class PrizeType(val answer: Int, val prizeMoney: Int) {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    companion object {
        fun findPrizeMoney(answer: Int): Int {
            return values().find { it.answer == answer }?.prizeMoney ?: 0
        }

        fun findAnswer(answer: Int): Int {
            return values().find { it.answer == answer }?.answer ?: 0
        }
    }
}
