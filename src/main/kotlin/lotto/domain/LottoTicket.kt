package lotto.domain

data class LottoTicket(val numbers: Set<LottoNumber>) {

    init {
        require(hasValidCount(numbers)) { "$NUMBER_COUNT 개의 중복되지 않은 번호가 필요합니다." }
    }

    fun getMatchCount(other: WinningLottoTicket) = numbers.count { other.lottoTicket.hasNumber(it) }

    fun hasNumber(number: LottoNumber) = numbers.contains(number)

    override fun toString() = "[${numbers.joinToString { it.value.toString() }}]"

    companion object {
        const val NUMBER_COUNT = 6

        private fun hasValidCount(numbers: Set<LottoNumber>) = numbers.size == NUMBER_COUNT
    }
}
