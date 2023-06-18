package lotto

@JvmInline
value class LottoNumber(
    val number: Int
) {
    init {
        require(LOTTO_NUMBER_RANGE.contains(number)) {
            "${LOTTO_NUMBER_RANGE.first}~${LOTTO_NUMBER_RANGE.last} 범위 숫자여야 합니다."
        }
    }

    override fun toString(): String {
        return "$number"
    }

    companion object {
        val LOTTO_NUMBER_RANGE: IntRange = 1..45

        fun forBonusOf(number: Int, winningLotto: Lotto): LottoNumber {
            require(winningLotto.lottoNumbers.none { it.number == number }) { "당첨 로또 번호와 보너스 번호는 중복될 수 없습니다." }
            return LottoNumber(number)
        }
    }
}
