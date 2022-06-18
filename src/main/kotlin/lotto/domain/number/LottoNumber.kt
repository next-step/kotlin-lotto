package lotto.domain.number

private val LOTTO_NUMBER_RANGE = 1..45

@JvmInline
value class LottoNumber private constructor(val value: Int) {
    companion object {
        private val LOTTO_NUMBER_CACHE = LOTTO_NUMBER_RANGE.associateWith { LottoNumber(it) }

        fun from(value: Int): LottoNumber {
            return LOTTO_NUMBER_CACHE[value] ?: throw IllegalArgumentException("로또 번호는 ${LOTTO_NUMBER_RANGE}의 범위입니다.")
        }
    }
}
