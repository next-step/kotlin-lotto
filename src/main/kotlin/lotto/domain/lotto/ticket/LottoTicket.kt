package lotto.domain.lotto.ticket

import lotto.domain.lotto.number.LottoNumber


data class LottoTicket(val lottoNumberList: List<LottoNumber>) {

    companion object {
        const val TOTAL_COUNT_LOTTO_NUMBER = 6
        fun randomGenerate() = LottoTicket(LottoNumber.randomShuffle(TOTAL_COUNT_LOTTO_NUMBER))
    }

    override fun toString(): String {
        return lottoNumberList.joinToString(", ", "[", "]")
    }
}
