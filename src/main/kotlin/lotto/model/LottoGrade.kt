package lotto.model

private const val PLUS_MATCH_COUNT = 5

enum class LottoGrade(val correctNumber: Int, val matchPlus: Boolean, val reward: Long) {
    BOOM(0, false, 0),
    BAD_GRADE(1, false, 0),
    UNLUCKY_GRADE(2, false, 0),
    BASIC_GRADE(3, false, 5_000),
    THIRD_GRADE(4, false, 50_000),
    SECOND_GRADE(5, false, 1_500_000),
    SECOND_PLUS_GRADE(5, true, 30_000_000),
    FIST_GRADE(6, false, 20_000_000_000);

    companion object {
        fun find(correctNumber: Int, matchPlus: Boolean) =
            LottoGrade.values().find {
                it.correctNumber == correctNumber
                        && it.matchPlus == (correctNumber == PLUS_MATCH_COUNT && matchPlus)
            } ?: throw IllegalArgumentException("로또 등급을 찾을 수 없습니다")
    }
}
