package lotto.domain.numbers

@JvmInline
value class LottoNumber private constructor(val number: Int) {
    companion object {
        val LOTTO_NUMBER_POOL = (1..45).associateWith { LottoNumber(it) }

        fun from(number: Int): LottoNumber {
            return LOTTO_NUMBER_POOL[number] ?: throw IllegalArgumentException("로또 번호는 1과 45사이의 숫자여야 합니다.")
        }
    }
}
