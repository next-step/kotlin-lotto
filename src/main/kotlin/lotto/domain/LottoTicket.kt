package lotto.domain

sealed class LottoTicket(numbers: Set<LottoNumber>) : Set<LottoNumber> by numbers {

    init {
        require(numbers.size == SIZE_OF_LOTTO_NUMBER)
    }

    fun getMatch(lastNumbers: LottoLastNumbers): LottoMatch {
        val matchCount = intersect(lastNumbers).size
        val isContainBonus = contains(lastNumbers.bonus)
        return LottoMatch.find(matchCount, isContainBonus)
    }

    data class ManualLottoTicket(private val numbers: Set<LottoNumber>) : LottoTicket(numbers)
    data class AutoLottoTicket(private val numbers: Set<LottoNumber>) : LottoTicket(numbers)

    companion object {
        const val SIZE_OF_LOTTO_NUMBER = 6
    }
}
