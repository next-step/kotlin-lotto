package lotto.domain

object LottoMachine {
    fun generateTickets(ticketCount: Int): List<Lotto> {
        check(ticketCount > 0) { "로또 생성 개수는 1개 이상이어야 합니다." }
        return List(ticketCount) { Lotto.generateAuto() }
    }
}
