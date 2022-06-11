package lotto

@JvmInline
value class LottoNumber private constructor(val value: Int) {

    companion object {

        fun of(value: Int): LottoNumber {
            return this.CACHE_LOTTO_NUMBERS[value] ?: throw IllegalArgumentException("로또 번호는 1이상 45이하의 숫자여야 합니다.")
        }

        private val CACHE_LOTTO_NUMBERS: Map<Int, LottoNumber> = List(45) { it + 1 to LottoNumber(it + 1) }.toMap()
    }
}
