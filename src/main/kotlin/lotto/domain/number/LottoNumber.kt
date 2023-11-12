package lotto.domain.number

@JvmInline
value class LottoNumber private constructor(
    val value: Int,
) {

    companion object {
        private const val LOTTO_MIN_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45
        private val LOTTO_NUMBERS = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER).associateWith(::LottoNumber)

        fun from(value: Int): LottoNumber {
            return LOTTO_NUMBERS[value]
                ?: throw IllegalArgumentException("로또 번호는 ${LOTTO_MIN_NUMBER}부터 $LOTTO_MAX_NUMBER 사이 값이어야 합니다.")
        }

        fun getLottoNumbers(): List<LottoNumber> {
            return LOTTO_NUMBERS.values.toList()
        }
    }
}
