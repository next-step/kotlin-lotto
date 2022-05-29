package lotto.domain

data class LottoTicket(
    private val numbers: Set<LottoNumber>,
    val isManual: Boolean = false
) : Set<LottoNumber> by numbers {

    init {
        require(size == SIZE_OF_LOTTO_NUMBER)
    }

    fun getMatch(lastNumbers: LottoLastNumbers): LottoMatch {
        val matchCount = intersect(lastNumbers).size
        val isContainBonus = contains(lastNumbers.bonus)
        return LottoMatch.find(matchCount, isContainBonus)
    }

    companion object {
        const val SIZE_OF_LOTTO_NUMBER = 6

        fun of(vararg number: Int): LottoTicket = LottoTicket(number.toSet().toLottoNumber())
    }
}
