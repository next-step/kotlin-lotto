package study.lotto.domain

enum class PrizeGrade(val matchCount: Int, val prizeAmount: Long, val matchbonusNumber: Boolean) {
    GRADE_DROP(0, 0, false),
    GRADE_5(3, 5_000, false),
    GRADE_4(4, 50_000, false),
    GRADE_3(5, 1_500_000, false),
    GRADE_2(5, 30_000_000, true),
    GRADE_1(6, 2_000_000_000, false)
    ;

    companion object {
        operator fun get(matchCount: Int, matchBonusNumber: Boolean): PrizeGrade = when (matchCount) {
            GRADE_5.matchCount -> GRADE_5
            GRADE_4.matchCount -> GRADE_4
            GRADE_1.matchCount -> GRADE_1
            GRADE_3.matchCount,
            GRADE_2.matchCount -> if (matchBonusNumber) {
                GRADE_2
            } else {
                GRADE_3
            }
            else -> GRADE_DROP
        }
    }
}
