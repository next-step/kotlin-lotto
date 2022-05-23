package lotto.domain

fun interface LottoMachine {
    fun generate(): LottoTicket
}
