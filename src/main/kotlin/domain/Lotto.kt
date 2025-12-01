package domain

import domain.LottoWinningType.NONE

data class Lotto(
    val numbers: Set<LottoNumber>,
) {
    init {
        require(numbers.size == SIZE) {
            "A lotto must contain exactly $SIZE unique numbers."
        }
    }

    fun determineWinningType(winningLotto: Lotto): LottoWinningType {
        val matchingCount = winningLotto.numbers.intersect(numbers).count()
        return LottoWinningType.entries.find { it.matchingCount == matchingCount } ?: NONE
    }

    companion object {
        const val SIZE = 6

        fun fromNumbers(vararg numbers: Int): Lotto = Lotto(numbers.map { LottoNumber(it) }.toSet())
    }
}
