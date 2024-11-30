package lotto.domain

data class LottoTicket(val lottos: List<Lotto>) {
    init {
        require(lottos.isNotEmpty()) { "로또 티켓은 적어도 하나의 로또를 포함해야 합니다." }
    }
}
