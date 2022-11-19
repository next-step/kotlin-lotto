package lotto

enum class LottoGrade(private val correctNumber: Int, val reward: Long) {
    BOOM(0, 0),
    BAD_GRADE(1, 0),
    UNLUCKY_GRADE(2, 0),
    BASIC_GRADE(3, 5_000),
    THIRD_GRADE(4, 50_000),
    SECOND_GRADE(5, 1_500_000),
    FIST_GRADE(6, 20_000_000_000);

    companion object {
        fun find(correctNumber: Int) =
            LottoGrade.values().find { it.correctNumber == correctNumber }
    }
}
