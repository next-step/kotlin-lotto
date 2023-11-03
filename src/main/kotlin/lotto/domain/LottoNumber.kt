package lotto.domain

@JvmInline
value class LottoNumber(val number: Int) {

    init {
        validateLottoNumber()
    }

    private fun validateLottoNumber() {
        require(number in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX) {
            "로또 숫자는 $LOTTO_NUMBER_MIN~${LOTTO_NUMBER_MAX}의 숫자만 가질 수 있습니다."
        }
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        const val LOTTO_NUMBER_MIN = 1
        const val LOTTO_NUMBER_MAX = 45
    }
}
