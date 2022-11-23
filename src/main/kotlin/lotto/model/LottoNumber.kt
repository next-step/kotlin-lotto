package lotto.model

private val LOTTO_NUMBER_RANGE = (1..45).toList()

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        validLottoNumberRange(number)
    }

    private fun validLottoNumberRange(number: Int) {
        require(number in LOTTO_NUMBER_RANGE) { "로또 번호 범위에 맞지 않는 숫자가 존재 합니다" }
    }

    override fun toString(): String = number.toString()
}
