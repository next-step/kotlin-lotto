package lotto.domain.lotto

class LottoTicket private constructor(
    val lottoType: LottoType,
    val numbers: Set<LottoNumber>
) {

    fun hasNumber(number: LottoNumber) = numbers.contains(number)

    fun matchCount(lottoTicket: LottoTicket) = this.numbers.count { lottoTicket.hasNumber(it) }

    override fun toString() = "[${numbers.joinToString()}]"

    companion object {
        const val NUMBER_COUNT = 6

        private fun hasValidCount(numbers: Set<LottoNumber>) = numbers.size == NUMBER_COUNT

        fun of(lottoType: LottoType, numbers: Set<LottoNumber>): LottoTicket? {
            if (hasValidCount(numbers)) {
                return LottoTicket(lottoType, numbers.toSortedSet())
            }
            return null
        }

        fun of(lottoType: LottoType, vararg numbers: Int) = of(lottoType, numbers.map { LottoNumber.of(it) }.toSet())
    }
}
