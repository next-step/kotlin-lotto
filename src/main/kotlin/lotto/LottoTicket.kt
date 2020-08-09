package lotto

class LottoTicket(count: Int) {
    val lottos: List<Lotto> = List(count) { Lotto(1, 2, 3, 4, 5, 6) }
}
