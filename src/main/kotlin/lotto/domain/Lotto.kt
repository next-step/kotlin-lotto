package lotto.domain


data class Lotto(val elements: Set<LottoNumber>) {

    init {
        require(elements.size == SIZE)
    }

    fun matchCount(other: Lotto): Int {
        return elements.filter { it in other.elements }.count()
    }

    companion object {
        const val SIZE = 6
        val PRICE = Money(1000)
    }
}
