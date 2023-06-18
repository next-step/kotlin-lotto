package lotto

@JvmInline
value class LottoNumber private constructor(
    val number: Int,
) {
    override fun toString(): String {
        return "$number"
    }

    companion object {
        val LOTTO_NUMBER_RANGE: IntRange = 1..45
        private val LOTTO_NUMBERS: Map<Int, LottoNumber> = LOTTO_NUMBER_RANGE.associateWith { LottoNumber(it) }

        operator fun invoke(number: Int): LottoNumber {
            return LOTTO_NUMBERS[number]
                ?: throw IllegalArgumentException("${LOTTO_NUMBER_RANGE.first}~${LOTTO_NUMBER_RANGE.last} 범위 숫자여야 합니다.")
        }

        fun forBonusOf(number: Int, winningLotto: Lotto): LottoNumber {
            require(winningLotto.lottoNumbers.none { it.number == number }) { "당첨 로또 번호와 보너스 번호는 중복될 수 없습니다." }
            return LottoNumber(number)
        }
    }
}
