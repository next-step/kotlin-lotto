package lotto.model

import lotto.Const

class LottoTicket(
    private val value: Set<LottoNumber>
) {
    init {
        require(value.size == LOTTO_NUMBER_COUNT) { Const.ErrorMsg.LOTTO_TICKET_NUMBER_IS_NOT_6_ERROR_MSG }
    }

    fun compareEqualCount(other: LottoTicket): Int =
        this.value.mapNotNull { lottoNumber ->
            other.value.find { it == lottoNumber }
        }.size

    override fun toString() = buildString {
        append("[")
        value.forEachIndexed { index, lottoNumber ->
            append(lottoNumber)
            if (index != LOTTO_NUMBER_COUNT - 1) {
                append(", ")
            }
        }
        append("]")
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6

        fun new(): LottoTicket {
            val lottoNumbers = mutableSetOf<LottoNumber>()
            while (lottoNumbers.size < LOTTO_NUMBER_COUNT) {
                lottoNumbers.add(LottoNumber.random())
            }
            return LottoTicket(lottoNumbers)
        }
    }
}
