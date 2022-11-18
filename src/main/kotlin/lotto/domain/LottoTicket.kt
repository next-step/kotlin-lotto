package lotto.domain

class LottoTicket(val lottoCount: Int) {
    val lottoList: List<Lotto> = List(lottoCount) { Lotto() }
}
