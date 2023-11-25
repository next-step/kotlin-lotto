package lotto.domain

data class LottoNumbers(
    val lottoNumbers: Set<LottoNumber>,
) {

    init {
        require(lottoNumbers.size == LOTTO_NUMBERS_SIZE) {
            "로또 숫자는 ${LOTTO_NUMBERS_SIZE}개입니다."
        }
    }

    fun countMatchingLottoNumbers(other: LottoNumbers): Int {
        return lottoNumbers.intersect(other.lottoNumbers).size
    }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }

    companion object {
        const val LOTTO_NUMBERS_SIZE = 6

        fun of(numbers: Set<Int>): LottoNumbers {
            return LottoNumbers(numbers.map(::LottoNumber).toSet())
        }
    }
}
