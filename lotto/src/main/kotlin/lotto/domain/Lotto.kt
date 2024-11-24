package lotto.domain

import lotto.domain.enums.LottoCompensationStrategy

data class Lotto(
    val values: Set<Int> = generateLotto(),
    private var correctCount: Int? = null,
) {
    val markedCorrectCount
        get() = correctCount ?: error("[Lotto] 마킹이 되지 않은 로또입니다.")

    val compensation
        get() = LottoCompensationStrategy.getCompensationByCorrectCount(markedCorrectCount)

    fun markCorrectCount(correctCount: Int) {
        if (this.correctCount != null) {
            error("[Lotto] 이미 당첨 개수 마킹이 완료된 로또입니다. | 로또 당첨개수: '$this', 마킹 시도한 당첨개수: $correctCount")
        }
        this.correctCount = correctCount
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6

        private fun generateLotto(): Set<Int> {
            return (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
                .shuffled()
                .take(LOTTO_NUMBER_COUNT)
                .toSet()
        }
    }
}
