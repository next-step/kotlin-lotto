package lotto.domain

data class Lotto(
    val lottoNumbers: LottoNumbers,
) {
    init {
        require(lottoNumbers.numbers.size == LottoNumbers.LOTTO_NUMBER_COUNT) { IllegalArgumentException::class.java }
    }

    fun matchLotto(
        winnerNumbers: List<Int>,
        bonusNumber: Int,
    ): LottoRank {
        val matchingNumbers = lottoNumbers.numbers.count { winnerNumbers.contains(it) }
        val matchingBonus = lottoNumbers.numbers.contains(bonusNumber)
        return LottoRank.from(matchingNumbers, matchingBonus)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
