package domain.lotto

import domain.winning.LottoWinningType

data class Lotto(
    val numbers: Set<LottoNumber>,
) {
    init {
        require(numbers.size == SIZE) {
            "A lotto must contain exactly $SIZE unique numbers."
        }
    }

    fun determineWinningType(
        winningLotto: Lotto,
        bonusNumber: LottoNumber,
    ): LottoWinningType {
        val matchingCount = winningLotto.numbers.intersect(numbers).count()
        val bonusNumberMatched = bonusNumber in numbers
        return LottoWinningType.of(matchingCount, bonusNumberMatched)
    }

    companion object {
        const val SIZE = 6

        fun fromNumbers(vararg numbers: Int): Lotto = Lotto(numbers.map { LottoNumber(it) }.toSet())
    }
}
