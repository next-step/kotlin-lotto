package lotto.model

interface LottoTicketGenerator {
    fun generate(): List<Int>
}
