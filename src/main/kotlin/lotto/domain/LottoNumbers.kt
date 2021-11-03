package lotto.domain

@JvmInline
value class LottoNumbers private constructor(val values: List<LottoNumber>) {

    init {
        verify()
    }

    private fun verify() {
        require(values.size == LOTTO_NUMBER_COUNTS) { "6개의 번호를 선택해야 합니다." }
        require(values.distinct().count() == LOTTO_NUMBER_COUNTS) { "중복된 번호를 선택할 수 없습니다." }
    }

    companion object {
        const val LOTTO_NUMBER_COUNTS = 6

        fun of(values: List<LottoNumber>): LottoNumbers {
            return LottoNumbers(values)
        }
    }
}
