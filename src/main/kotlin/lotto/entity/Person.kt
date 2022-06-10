package lotto.entity

interface Person {
    fun purchase(money: Int): List<LottoTicket>
}
