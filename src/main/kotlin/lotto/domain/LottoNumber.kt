package lotto.domain

import lotto.domain.LottoLineGenerator.LOTTO_NUMBER_RANGE

@JvmInline
value class LottoNumber private constructor(
    private val number: Int
) {
    companion object {
        private val NUMBERS: Map<Int, LottoNumber> = LOTTO_NUMBER_RANGE.associateWith(::LottoNumber)
        fun from(value: Int): LottoNumber = NUMBERS[value] ?: throw IllegalArgumentException("[입력:$value] 1에서 45사이의 정수만 허용됩니다.")
    }

    override fun toString(): String = "$number"
}
