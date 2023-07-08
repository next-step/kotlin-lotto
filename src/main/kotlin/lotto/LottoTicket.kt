package lotto

class LottoTicket(private val lottos: List<Lotto>) {
    fun match(winningLotto: Lotto): List<Match> {
        TODO("Not yet implemented")
    }

    init {
        require(lottos.isNotEmpty()) { "로또는 1개 이상 구매해야 합니다." }
    }

    companion object {
        fun from(lottos: List<List<Int>>): LottoTicket {
            return LottoTicket(lottos.map { Lotto.from(it) })
        }
    }
}
