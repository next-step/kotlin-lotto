package lotto

class LottoTicket(val money: Money, val lottos: List<Lotto>) {
    fun count(): Int {
        return lottos.size
    }
}
