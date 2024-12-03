package lotto.domain

data class Lotto(
    val lottoNumbers: LottoNumbers,
) {
    init {
        require(lottoNumbers.numbers.size == LottoNumbers.LOTTO_NUMBER_COUNT) { IllegalArgumentException::class.java }
    }

    fun matchLotto(winnerNumbers: List<Int>): LottoRank {
        val matchingNumbers = lottoNumbers.numbers.count { winnerNumbers.contains(it) }
        return LottoRank.from(matchingNumbers)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
