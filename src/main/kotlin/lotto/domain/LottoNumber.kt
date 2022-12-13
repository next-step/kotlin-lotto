package lotto.domain

private const val MIN_NUMBER = 1
private const val MAX_NUMBER = 45

@JvmInline
value class LottoNumber private constructor(val value: Int) {
    companion object {
        private val CACHE: Map<Int, LottoNumber> = (MIN_NUMBER..MAX_NUMBER).associateWith { LottoNumber(it) }

        fun from(value: Int): LottoNumber {
            return CACHE[value] ?: throw IllegalArgumentException("로또 번호는 1~45 범위의 값을 허용합니다.")
        }

        fun values(): List<LottoNumber> {
            return CACHE.values
                .toList()
        }
    }
}
