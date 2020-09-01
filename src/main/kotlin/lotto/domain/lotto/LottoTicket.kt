package lotto.domain.lotto

class LottoTicket private constructor(
    val lottoType: LottoType,
    val numbers: Set<LottoNumber>
) {

    fun hasNumber(number: Int) = numbers.contains(LottoNumber.of(number))

    fun hasNumber(number: LottoNumber) = numbers.contains(number)

    override fun toString() = "[${numbers.joinToString()}]"

    companion object {
        const val NUMBER_COUNT = 6

        private fun hasValidCount(numbers: Set<LottoNumber>) = numbers.size == NUMBER_COUNT

        operator fun invoke(lottoType: LottoType, numbers: Set<LottoNumber>): LottoTicket? {
            if (hasValidCount(numbers)) {
                return LottoTicket(lottoType, numbers.toSortedSet())
            }
            return null
        }

        operator fun invoke(lottoType: LottoType, vararg numbers: Int) =
            invoke(lottoType, numbers.map { LottoNumber.of(it) }.filterNotNull().toSet())
    }
}
