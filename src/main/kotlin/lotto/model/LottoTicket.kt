package lotto.model

import lotto.Const

class LottoTicket(
    private val lottoTicket: Set<LottoNumber>
) {
    init {
        require(lottoTicket.size == LOTTO_NUMBER_COUNT) { Const.ErrorMsg.LOTTO_TICKET_NUMBER_IS_NOT_6_ERROR_MSG }
    }

    fun get() = lottoTicket.sortedBy { it.get() }.toSet()

    override fun toString() = buildString {
        append("[")
        get().forEachIndexed { index, lottoNumber ->
            if (index == LOTTO_NUMBER_COUNT - 1) {
                append("${lottoNumber.get()}")
            } else {
                append("${lottoNumber.get()}, ")
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
