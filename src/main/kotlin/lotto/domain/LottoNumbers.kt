package lotto.domain

data class LottoNumbers(
    val value: List<LottoNumber>,
) {
    init {
        require(value.size == LOTTO_NUMBER_SIZE) { "로또 번호는 ${LOTTO_NUMBER_SIZE}개만 입력할 수 있습니다. [${value.size}]" }
        require(value.distinct().size == LOTTO_NUMBER_SIZE) { "로또 번호는 중복될 수 없습니다. [$value]" }
    }

    fun match(lottoNumbers: LottoNumbers): Int {
        return value.intersect(lottoNumbers.value).size
    }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return value.contains(lottoNumber)
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6

        fun of(numbers: List<Int>): LottoNumbers {
            return LottoNumbers(numbers.map { LottoNumber(it) })
        }
    }
}
