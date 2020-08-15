package lotto.domain.lotto

data class LottoTicket(
    val lottoType: LottoType,
    val numbers: Set<LottoNumber>
) {

    init {
        require(hasValidCount(numbers)) { "$NUMBER_COUNT 개의 중복되지 않은 번호가 필요합니다." }
    }

    constructor(lottoType: LottoType, vararg numbers: Int) : this(
        lottoType,
        numbers.map { LottoNumber(it) }.toSortedSet()
    )

    fun hasNumber(number: LottoNumber) = numbers.contains(number)

    override fun toString() = "[${numbers.joinToString()}]"

    companion object {
        const val NUMBER_COUNT = 6

        private fun hasValidCount(numbers: Set<LottoNumber>) = numbers.size == NUMBER_COUNT
    }
}
