package lotto.domain

enum class Winning(val prise: Int) {
    FIRST(2000000000),
    SECOND(1500000),
    THIRD(50000),
    FOURTH(5000),
    FAIL(0);


    companion object {
        fun getWinningResult(matchCount: Int): Winning {
            return when(matchCount) {
                6 -> FIRST
                5 -> SECOND
                4 -> THIRD
                3 -> FOURTH
                else -> FAIL
            }
        }
    }
}
