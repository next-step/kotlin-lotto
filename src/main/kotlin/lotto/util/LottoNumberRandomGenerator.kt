package lotto.util

class LottoNumberRandomGenerator : LottoNumberGenerator {
    override fun numberSet(): List<Int> {
        return lottoNumberList.shuffled().subList(LOTTO_START_DIGIT, LOTTO_END_DIGIT).sorted()
    }

    companion object {
        private const val LOTTO_START_DIGIT = 0
        private const val LOTTO_END_DIGIT = 6
        private const val LOTTO_ISSUANCE_NUMBER_START = 1
        private const val LOTTO_ISSUANCE_NUMBER_END = 45
        private val lottoNumberList: Set<Int> = (LOTTO_ISSUANCE_NUMBER_START..LOTTO_ISSUANCE_NUMBER_END).toSet()
    }
}
