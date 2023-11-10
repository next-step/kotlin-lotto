package lotto.model

@JvmInline
value class LottoNumber private constructor(val number: Int) {
    companion object {
        val NUMBER_RANGE = 1..45
        private val NUMBERS: Map<Int, LottoNumber> = NUMBER_RANGE.associateWith { LottoNumber(it) }

        fun from(number: Int): LottoNumber = NUMBERS[number]
            ?: throw IllegalArgumentException("로또 번호는 ${NUMBER_RANGE.first}~${NUMBER_RANGE.last} 사이여야 합니다.")
    }
}
