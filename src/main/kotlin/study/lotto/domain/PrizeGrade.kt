package study.lotto.domain

enum class PrizeGrade(val matchCount: Int, val prizeAmount: Long) {
    GRADE_5(3, 5_000),
    GRADE_4(4, 50_000),
    GRADE_3(5, 1_500_000),
    GRADE_1(6, 2_000_000_000),
    ;

    companion object {
        fun getPrizeAmount(matchCount: Int): Long {
            return values().find { it.matchCount == matchCount }?.prizeAmount ?: 0
        }
    }
}
