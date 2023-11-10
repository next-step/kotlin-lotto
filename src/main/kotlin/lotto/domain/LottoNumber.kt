package lotto.domain

@JvmInline
value class LottoNumber(
    val value: Int,
) {

    init {
        validateNumber()
    }

    private fun validateNumber() {
        require(value in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) {
            "로또 번호는 ${LOTTO_MIN_NUMBER}부터 $LOTTO_MAX_NUMBER 사이 값이어야 합니다."
        }
    }

    companion object {
        private const val LOTTO_MIN_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45
    }
}
