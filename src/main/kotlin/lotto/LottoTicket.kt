package lotto

class LottoTicket(count: Int) {
    // TODO 랜덤로직 구현
    val lottos: List<Lotto> = List(count) { Lotto(1, 2, 3, 4, 5, 6) }
}
