package lotto.model

private val LOTTO_NUMBER_RANGE = 1..45
private val LOTTO_NUMBERS = LOTTO_NUMBER_RANGE.toList()

class LottoTicket(lottoTicket: List<Lotto>) {
    private val lottoTicket: MutableList<Lotto> = lottoTicket.toMutableList()

    fun gameResult(winningLotto: Lotto, bonus: LottoNumber): GameResults {
        return GameResults(lottoTicket.map { it.rank(winningLotto, bonus) })
    }

    fun addLotto(lotto: Lotto) {
        this.lottoTicket.add(lotto)
    }

    fun addTicket(lottoTicket: LottoTicket) {
        this.lottoTicket.addAll(lottoTicket.lottoTicket)
    }

    override fun toString(): String {
        return "${ this.lottoTicket.joinToString("\n") }"
    }

    companion object {
        fun createRandomLotto(count: Int): LottoTicket {
            val lottoTicket = LottoTicket(emptyList())
            repeat(count) {
                lottoTicket.addLotto(Lotto(LOTTO_NUMBERS.shuffled().take(6).sorted().map { LottoNumber.from(it) }))
            }
            return lottoTicket
        }
    }
}
