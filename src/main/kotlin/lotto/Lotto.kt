package lotto

class Lotto(
    val lottoNumbers: Set<Int>,
) {

    init {
        require(lottoNumbers.size == LOTTO_NUMBER_SIZE) { "로또 숫자는 ${LOTTO_NUMBER_SIZE}개입니다." }
        lottoNumbers.forEach { checkNumberInRange(it) }
    }

    fun matchNumberCount(other: Lotto) =
        lottoNumbers.intersect(other.lottoNumbers).size

    private fun checkNumberInRange(number: Int) {
        require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) {
            "로또 숫자 범위는 $MIN_LOTTO_NUMBER~${MAX_LOTTO_NUMBER}입니다."
        }
    }

    companion object {
        const val LOTTO_PRICE = 1_000L
        const val LOTTO_NUMBER_SIZE = 6
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45

        fun issueByAuto(): Lotto {
            val lottoNumbers = generateRandomLottoNumbers()
            return Lotto(lottoNumbers)
        }

        private fun generateRandomLottoNumbers(): Set<Int> {
            val candidateLottoNumbers = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).toList()
            return candidateLottoNumbers
                .shuffled()
                .take(LOTTO_NUMBER_SIZE)
                .toSet()
        }
    }
}
