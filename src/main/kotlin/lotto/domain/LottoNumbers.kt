package lotto.domain

class LottoNumbers(
    val values: Set<LottoNumber>,
) {
    init {
        validateLengthOfNumbers(values)
    }

    private fun validateLengthOfNumbers(values: Set<LottoNumber>) {
        require(values.size == LOTTO_NUMBER_COUNT) { "로또 번호는 중복되지 않는 숫자 ${LOTTO_NUMBER_COUNT}개로 구성되어야 합니다." }
    }

    fun getMatchCount(other: LottoNumbers): Int {
        return this.values.intersect(other.values).size
    }

    fun isContains(lottoNumber: LottoNumber): Boolean {
        return values.contains(lottoNumber)
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6

        fun random(): LottoNumbers = LottoNumbers(
            LottoNumber.all().shuffled().take(LOTTO_NUMBER_COUNT).toSet(),
        )

        fun from(values: Set<Int>): LottoNumbers = LottoNumbers(
            values.map { LottoNumber(it) }.toSet(),
        )
    }
}
