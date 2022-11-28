package lotto.domain

enum class Winner(val count: Int, val prize: Int, private val calculateReward: (Int, Int) -> Int) {
    FIRST_GRADE(6, FIRST_WIN_PRICE, { a, b -> a * b }),
    SECOND_GRADE(5, SECOND_WIN_PRICE, { a, b -> a * b }),
    THIRD_GRADE(4, THIRD_WIN_PRICE, { a, b -> a * b }),
    FOURTH_GRADE(3, FOURTH_WIN_PRICE, { a, b -> a * b }),
    FIVE_GRADE(2, 0, { a, b -> a * b }),
    SIX_GRADE(1, 0, { a, b -> a * b }),
    NO_MATCH(0, 0, { a, b -> a * b });

    fun calculate(numberOfMatchingLotto: Int): Int = calculateReward(prize, numberOfMatchingLotto)

    companion object {

        fun safeValueOf(count: Int): Winner {
            return Winner.values().find { it.count == count } ?: NO_MATCH
        }
    }
}