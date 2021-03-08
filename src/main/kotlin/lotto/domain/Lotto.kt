package lotto.domain


data class Lotto(val elements: Set<LottoNumber>) {

    init {
        require(elements.size == SIZE)
    }

    fun matchCount(lotto: Lotto): Int {
        return elements.filter { lottoNumber -> lotto.contains(lottoNumber) }.count()
    }

    private fun contains(number: LottoNumber) = elements.contains(number)

    companion object {
        const val SIZE = 6
        val PRICE = Money(1000)
    }
}
