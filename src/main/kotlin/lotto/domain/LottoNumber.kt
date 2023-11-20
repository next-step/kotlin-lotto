package lotto.domain

@JvmInline
value class LottoNumber(
    val number: Int,
) {
    init {
        checkNumberInRange(number)
    }

    private fun checkNumberInRange(number: Int) {
        require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) {
            "로또 숫자 범위는 $MIN_LOTTO_NUMBER~${MAX_LOTTO_NUMBER}입니다."
        }
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
    }
}
