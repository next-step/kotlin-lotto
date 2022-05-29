package lotto.domain

import lotto.Const

class LottoTicket(
    private val value: Set<LottoNumber>
) {
    init {
        require(value.size == LOTTO_NUMBER_COUNT) { Const.ErrorMsg.LOTTO_TICKET_NUMBER_IS_NOT_6_ERROR_MSG }
    }

    fun countIntersect(other: LottoTicket): Int =
        this.value.mapNotNull { lottoNumber ->
            other.value.find { it == lottoNumber }
        }.size

    fun toSortedList(): List<LottoNumber> =
        value.sortedWith(CompareLottoNumbers)

    companion object {
        const val LOTTO_NUMBER_COUNT = 6

        fun new(): LottoTicket {
            val lottoNumbers = (LottoNumber.MIN_LOTTO_NUM..LottoNumber.MAX_LOTTO_NUM)
                .shuffled()
                .take(6)
                .map(::LottoNumber)
                .toSet()
            return LottoTicket(lottoNumbers)
        }
    }
}
