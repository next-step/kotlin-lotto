package lotto.domain.lotto.ticket

import lotto.domain.lotto.number.LottoNumber
import java.util.stream.Stream
import kotlin.streams.toList

open class LottoTicket(val lottoNumberList: List<LottoNumber>) : List<LottoNumber> by lottoNumberList {

    init {
        require(lottoNumberList.distinct().size == TOTAL_COUNT_LOTTO_NUMBER) {
            "LottoTicket must contain exactly $TOTAL_COUNT_LOTTO_NUMBER"
        }
    }

    companion object {
        const val TOTAL_COUNT_LOTTO_NUMBER = 6
        fun randomGenerate(): LottoTicket = LottoTicket(LottoNumber.randomShuffle(TOTAL_COUNT_LOTTO_NUMBER))

        fun randomGenerate(count: Int): List<LottoTicket> {
            require(count > 0) { "count should be greater than 0 [$count]" }

            return Stream.generate { randomGenerate() }
                .distinct()
                .limit(count.toLong())
                .toList()
        }
    }

    override fun toString(): String =
        lottoNumberList.joinToString(", ", "[", "]")
}
