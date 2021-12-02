package lotto.domain

enum class Winning(val matchCount : Int) {
    FIRST(6),
    SECOND(5),
    THIRD(4),
    FOURTH(3),
    FAIL(0);


    companion object {
        fun getWinningResult(matchCount: Int): Winning? {
            return values().find {
                    it.matchCount == matchCount
                }
        }
    }
}
