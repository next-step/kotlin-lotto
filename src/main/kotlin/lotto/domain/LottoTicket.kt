package lotto.domain

class LottoTicket(val lottos: List<Lotto>) {
    val countOfLotto: Int
        get() = lottos.size

    init {
        require(lottos.isNotEmpty()) { "로또는 1개 이상 구매해야 합니다." }
    }

    fun match(winningLotto: WinningLotto): MatchResult {
        return lottos.mapNotNull { winningLotto.match(it) }
            .run(::MatchResult)
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
