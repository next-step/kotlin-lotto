package lotto.domain

@JvmInline
value class LottoNumber private constructor(
    private val number: Int
) {
    companion object {
        private val LOTTO_NUMBER_RANGE = IntRange(1, 45)
        private val LOTTO_NUMBERS: Map<Int, LottoNumber> = LOTTO_NUMBER_RANGE.associateWith(::LottoNumber)
        fun from(value: Int): LottoNumber = LOTTO_NUMBERS[value] ?: throw IllegalArgumentException("[입력:$value] 1에서 45사이의 정수만 허용됩니다.")
        fun random() : LottoNumber = from(LOTTO_NUMBER_RANGE.random())
    }

    override fun toString(): String = "$number"
}
