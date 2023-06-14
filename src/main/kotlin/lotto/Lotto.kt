package lotto

class Lotto(
    val lottoNumbers: List<LottoNumber>,
) {
    init {
        require(lottoNumbers.size == lottoNumbers.distinct().size) { "로또번호는 중복이 없어야 합니다." }
        require(lottoNumbers.size == LOTTO_NUMBER_COUNT) { "로또번호는 ${LOTTO_NUMBER_COUNT}개 이어야 합니다." }
    }

    fun isMatchedByMatchCount(other: Lotto, matchCount: Int): Boolean {
        val matchedLottoNumbers = lottoNumbers.filter { other.lottoNumbers.contains(it) }
        return matchedLottoNumbers.size == matchCount
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6

        fun draw(): Lotto {
            return Lotto(randomLottoNumbers())
        }

        fun of(numbers: List<Int>): Lotto {
            return Lotto(numbers.map { LottoNumber(it) })
        }

        private fun randomLottoNumbers(): List<LottoNumber> {
            return LOTTO_NUMBER_RANGE.shuffled()
                .take(LOTTO_NUMBER_COUNT)
                .map { LottoNumber(it) }
        }
    }
}
