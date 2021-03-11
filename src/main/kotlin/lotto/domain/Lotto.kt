package lotto.domain

data class Lotto(val elements: Set<LottoNumber>) {

    init {
        require(elements.size == SIZE)
    }

    fun matchCount(other: Lotto): Int {
        return elements.count { it in other.elements }
    }

    fun contains(bonusNumber: LottoNumber) = bonusNumber in elements

    companion object {
        const val SIZE = 6
        val PRICE = Money(1000)
    }
}
