package lotto.domain

data class LottoTicket(private val numbers: Set<Int>) : Set<Int> by numbers {

    init {
        require(size == SIZE_OF_LOTTO_NUMBER)
        require(all { it in RANGE_OF_LOTTO_NUMBER })
    }

    fun getMatch(lastNumbers: LottoLastNumbers): LottoMatch {
        val matchCount = intersect(lastNumbers).size
        val isContainBonus = contains(lastNumbers.bonus)
        return LottoMatch.find(matchCount, isContainBonus)
    }

    companion object {
        private const val MIN_RANGE_OF_NUMBER = 1
        private const val MAX_RANGE_OF_NUMBER = 45
        const val SIZE_OF_LOTTO_NUMBER = 6
        val RANGE_OF_LOTTO_NUMBER = MIN_RANGE_OF_NUMBER..MAX_RANGE_OF_NUMBER

        fun of(vararg number: Int): LottoTicket = LottoTicket(number.toSet())
    }
}
