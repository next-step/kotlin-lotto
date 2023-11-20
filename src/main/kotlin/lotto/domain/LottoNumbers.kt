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

    companion object {
        const val LOTTO_NUMBERS_SIZE = 6

        fun of(numbers: Set<Int>): LottoNumbers {
            return LottoNumbers(numbers.map(::LottoNumber).toSet())
        }

        fun of(vararg numbers: Int): LottoNumbers {
            require(numbers.size == numbers.toSet().size) { "로또 숫자는 중복될 수 없습니다." }
            return LottoNumbers(numbers.map(::LottoNumber).toSet())
        }
    }
}
