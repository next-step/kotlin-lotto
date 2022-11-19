package lotto.model

private val LOTTO_NUMBER_RANGE = (1..45).toList()

object LottoNumberValidator {
    fun validNumber(number: List<Int>) {
        validLottoNumberSize(number)
        validLottoNumberRange(number)
    }

    private fun validLottoNumberSize(number: List<Int>) {
        require(number.size == 6) { "숫자는 6개가 존재해야 합니다" }
    }

    private fun validLottoNumberRange(number: List<Int>) {
        val rangeCheck = number.all { it in LOTTO_NUMBER_RANGE }
        if (!rangeCheck) {
            throw IllegalArgumentException("로또 번호 범위에 맞지 않는 숫자가 존재 합니다")
        }
    }
}
