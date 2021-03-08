package lotto.domain


data class Lotto(val elements: Set<LottoNumber>) {

    init {
        require(elements.size == TICKET_SIZE)
    }

    companion object {
        private const val TICKET_SIZE = 6
        val PRICE = Money(1000)
    }
}
