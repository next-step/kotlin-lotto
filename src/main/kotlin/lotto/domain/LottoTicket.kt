package lotto.domain

class LottoTicket(
    private val lottoTicket: Set<LottoNumber>
) {
    init {
        require(lottoTicket.size == LOTTO_NUMBER_COUNT) { "로또는 6개의 숫자로 이루어져 있습니다." }
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
