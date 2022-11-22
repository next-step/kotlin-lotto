package lotto.model

private val LOTTO_NUMBER_RANGE = (1..45).toList()

@JvmInline
value class LottoNumber(val number: List<Int>) {
    init {
        validLottoNumberSize(number)
        validLottoNumberRange(number)
    }

    private fun validLottoNumberSize(number: List<Int>) {
        require(number.distinct().size == 6) { "중복없는 숫자는 6개가 존재해야 합니다" }
    }

    private fun validLottoNumberRange(number: List<Int>) {
        require(number.all { it in LOTTO_NUMBER_RANGE }) { "로또 번호 범위에 맞지 않는 숫자가 존재 합니다" }
    }
}
