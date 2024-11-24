package lotto.domain.enums

private const val DEFAULT_COMPENSATION_UNIT = "원"

enum class LottoCompensationStrategy(
    val correctCount: Int,
    val compensation: Long,
    val unit: String,
) {
    `3개`(3, 5_000, DEFAULT_COMPENSATION_UNIT),
    `4개`(4, 50_000, DEFAULT_COMPENSATION_UNIT),
    `5개`(5, 1_500_000, DEFAULT_COMPENSATION_UNIT),
    `6개`(6, 2_000_000_000, DEFAULT_COMPENSATION_UNIT),
    ;

    companion object {
        private const val DEFAULT_COMPENSATION = 0L

        fun findByCorrectCount(correctCount: Int): LottoCompensationStrategy? =
            entries.find { it.correctCount == correctCount }

        fun getCompensationByCorrectCount(correctCount: Int): Long =
            findByCorrectCount(correctCount)?.compensation
                ?: DEFAULT_COMPENSATION
    }
}
