package lotto.domain

data class Lotto(val elements: Set<LottoNumber>) {

    init {
        require(elements.size == SIZE)
    }

    fun matchCount(other: Lotto): Int {
        return elements.count { it in other.elements }
    }

    operator fun contains(lottoNumber: LottoNumber) = lottoNumber in elements

    companion object {
        const val SIZE = 6
        val PRICE = Money(1000)
    }
}
