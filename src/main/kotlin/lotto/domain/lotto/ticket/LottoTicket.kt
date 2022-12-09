package lotto.domain.lotto.ticket

import lotto.domain.lotto.number.LottoNumber

data class LottoTicket(
    val lottoNumberList: List<LottoNumber>
) : List<LottoNumber> by lottoNumberList {

    constructor(vararg lottoNumber: Int) : this(lottoNumber.toList().map { LottoNumber(it) })

    init {
        require(lottoNumberList.distinct().size == TOTAL_COUNT_LOTTO_NUMBER) {
            "LottoTicket must contain exactly $TOTAL_COUNT_LOTTO_NUMBER"
        }
    }

    fun matchCount(other: LottoTicket): Int = this.intersect(other).size

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
