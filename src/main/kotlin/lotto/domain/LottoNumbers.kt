package lotto.domain

data class LottoNumbers(private val lottoNumbers: List<LottoNumber>) {
    fun getLottoNumbers() = lottoNumbers

    companion object {
        private const val ZERO = 0
        private const val MAXIMUM_LOTTO_SIZE = 6

        fun createRandom(): LottoNumbers {
            val allLottoNumbers = LottoNumber.getAllLottoNumbers()
            val shuffledLottoNumbers = allLottoNumbers.shuffled()

            return LottoNumbers(shuffledLottoNumbers.subList(ZERO, MAXIMUM_LOTTO_SIZE))
        }
    }
}
