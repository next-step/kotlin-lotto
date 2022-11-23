package lotto.model

@JvmInline
value class LottoNumbers(val numbers: List<LottoNumber>) {
    init {
        validLottoNumberSize(numbers)
    }

    private fun validLottoNumberSize(numbers: List<LottoNumber>) {
        require(numbers.distinct().size == 6) { "중복없는 숫자는 6개가 존재해야 합니다" }
    }

    fun size() = numbers.distinct().size
}
