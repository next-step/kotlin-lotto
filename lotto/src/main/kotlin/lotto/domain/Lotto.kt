package lotto.domain

data class Lotto(
    val values: List<Int> = generateLotto()
) {
    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6

        private fun generateLotto(): List<Int> {
            return (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).shuffled()
                .take(LOTTO_NUMBER_COUNT)
        }
    }
}
