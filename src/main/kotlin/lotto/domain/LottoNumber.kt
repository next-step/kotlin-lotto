package lotto.domain

private fun Int.isValidLottoNumber() = this in LottoNumber.START_LOTTO_NUMBER..LottoNumber.END_LOTTO_NUMBER

@JvmInline
value class LottoNumber(
    val number: Int
) {
    init {
        if (!number.isValidLottoNumber()) {
            throw IllegalArgumentException("로또 숫자는 1 부터 45 사이여야 합니다.")
        }
    }

    companion object {
        const val START_LOTTO_NUMBER = 1
        const val END_LOTTO_NUMBER = 45
    }
}
