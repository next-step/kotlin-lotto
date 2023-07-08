package lotto

class LottoTicket(private val lottos: List<Lotto>) {
    init {
        require(lottos.isNotEmpty()) { "로또는 1개 이상 구매해야 합니다." }
    }

    fun match(winningLotto: Lotto): List<Match> {
        return lottos.mapNotNull { it.match(winningLotto) }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoTicket

        return lottos == other.lottos
    }

    override fun hashCode(): Int {
        return lottos.hashCode()
    }

    companion object {
        fun from(lottos: List<List<Int>>): LottoTicket {
            return LottoTicket(lottos.map { Lotto.from(it) })
        }
    }
}
