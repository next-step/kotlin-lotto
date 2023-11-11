package lotto.domain

data class LottoNumber(
    val number: Int
) {
    init {
        validateLottoNumber()
    }

    private fun validateLottoNumber() {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw IllegalArgumentException("로또 번호는 1이상 45이하의 값이어야 합니다.")
        }
    }

    companion object {
        val MIN_VALUE = 1
        val MAX_VALUE = 45
    }
}
