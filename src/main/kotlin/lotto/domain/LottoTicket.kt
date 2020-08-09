package lotto.domain

data class LottoTicket(val numbers: Set<LottoNumber>) {

    init {
        require(hasValidCount(numbers)) { "$NUMBER_COUNT 개의 중복되지 않은 번호가 필요합니다." }
    }

    override fun toString() = "[${numbers.joinToString { it.value.toString() }}]"

    fun getMatchCount(other: LottoTicket) = numbers.count { other.numbers.contains(it) }

    companion object {
        const val NUMBER_COUNT = 6

        private fun hasValidCount(numbers: Set<LottoNumber>) = numbers.size == NUMBER_COUNT
    }
}
