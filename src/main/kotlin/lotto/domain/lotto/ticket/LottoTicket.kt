package lotto.domain.lotto.ticket

import lotto.domain.lotto.number.LottoNumber

open class LottoTicket(val lottoNumberList: List<LottoNumber>) : List<LottoNumber> by lottoNumberList {

    init {
        require(lottoNumberList.distinct().size == TOTAL_COUNT_LOTTO_NUMBER) {
            "LottoTicket must contain exactly $TOTAL_COUNT_LOTTO_NUMBER"
        }
    }

    companion object {
        const val TOTAL_COUNT_LOTTO_NUMBER = 6
        fun randomGenerate(): LottoTicket = LottoTicket(randomShuffle())

        fun randomShuffle(): List<LottoNumber> =
            LottoNumber.values()
                .shuffled()
                .take(TOTAL_COUNT_LOTTO_NUMBER)
                .sorted()
    }

    override fun toString(): String =
        lottoNumberList.joinToString(", ", "[", "]")
}
