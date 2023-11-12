package lotto.domain

data class LottoNumber(
    val number: Int
) {
    init {
        validateLottoNumber()
    }

    private fun validateLottoNumber() {
        check(number in MIN_VALUE..MAX_VALUE) {
            "로또 번호는 1이상 45이하의 값이어야 합니다."
        }
    }

    companion object {
        const val MIN_VALUE = 1
        const val MAX_VALUE = 45
    }
}
