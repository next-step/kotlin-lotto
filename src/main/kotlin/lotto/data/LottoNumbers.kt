package lotto.data

class LottoNumbers(
    numbers: List<Int>
) {
    val lottoNumbers = numbers.map { LottoNumber(it) }

    init {
        require(lottoNumbers.size == LOTTO_NUMBERS_SIZE) { "로또 번호의 개수는 6개여야 합니다." }
    }

    fun findMatchCount(otherNumbers: LottoNumbers): Int {
        return lottoNumbers.count { otherNumbers.contains(it) }
    }

    private fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }

    companion object {
        private const val LOTTO_NUMBERS_SIZE = 6
    }
}
