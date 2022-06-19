package game.domain.lotto

class Lotto(val tickets: List<LottoTicket>) {
    init {
        require(tickets.isNotEmpty()) { "로또는 1장 이상의 티켓으로 구성됩니다." }
    }
}
