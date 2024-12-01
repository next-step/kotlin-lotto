package lotto.domain

class Lotto(
    val lottoNumbers: List<Int>,
) {
    init {
        require(lottoNumbers.size == 6) { IllegalArgumentException::class.java }
    }

    fun matchLotto(winnerNumbers: List<Int>): LottoRank? {
        val matchingNumbers = lottoNumbers.count { winnerNumbers.contains(it) }
        return LottoRank.from(matchingNumbers)
    }

    companion object {
        fun from(numbers: List<Int>) = Lotto(numbers)
    }
}
