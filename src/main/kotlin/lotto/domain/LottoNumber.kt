package lotto.domain

@JvmInline
value class LottoNumber(
    val value: Int,
) {

    init {
        validateRange()
    }

    private fun validateRange() {
        require(value in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) {
            "로또 번호는 ${LOTTO_MIN_NUMBER}부터 $LOTTO_MAX_NUMBER 사이 값이어야 합니다."
        }
    }

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
    }
}
