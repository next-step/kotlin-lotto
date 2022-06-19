package lotto.component

const val START_LOTTO_NUMBER = 1
const val LAST_LOTTO_NUMBER = 45

private fun Int.isValidLottoNumber() = this in START_LOTTO_NUMBER..LAST_LOTTO_NUMBER

@JvmInline
value class LottoNumber private constructor(
    val number: Int
) {

    companion object {
        fun from(number: Int): LottoNumber {
            if (!number.isValidLottoNumber()) {
                throw IllegalArgumentException("로또 숫자는 1 부터 45 사이여야 합니다.")
            }
            return LottoNumber(number)
        }
    }
}
