package lotto

interface LottoGeneratorStrategy {
    fun generate(count: Int): List<LottoNumbers>

    companion object {
        private const val FIRST_NUMBER: Int = 1
        private const val LAST_NUMBER: Int = 45
        val ALL_LOTTO_NUMBERS = (FIRST_NUMBER..LAST_NUMBER).toSet()
    }
}
