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

    data class ManualLottoTicket(private val numbers: Set<LottoNumber>) : LottoTicket(numbers) {
        constructor(vararg number: Int) : this(number.toSet().toLottoNumber())
    }

    data class AutoLottoTicket(private val numbers: Set<LottoNumber>) : LottoTicket(numbers) {
        constructor(vararg number: Int) : this(number.toSet().toLottoNumber())
    }

    data class LastLottoTicket(private val numbers: Set<LottoNumber>) : LottoTicket(numbers) {
        constructor(vararg number: Int) : this(number.toSet().toLottoNumber())
    }

    companion object {
        const val SIZE_OF_LOTTO_NUMBER = 6
    }
}
