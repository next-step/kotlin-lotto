package lotto.model

private val LOTTO_NUMBER_RANGE = 1..45
private val LOTTO_NUMBERS = LOTTO_NUMBER_RANGE.toList()

class LottoTicket(lottoTicket: List<Lotto>) {
    private val lottoTicket: MutableList<Lotto> = lottoTicket.toMutableList()

    fun createRandomLotto() {
        lottoTicket.add(
            Lotto(LOTTO_NUMBERS.shuffled().take(6).sorted().map { LottoNumber.from(it) })
        )
    }

    fun gameResult(winningLotto: Lotto, bonus: LottoNumber): GameResults {
        return GameResults(lottoTicket.map { it.rank(winningLotto, bonus) })
    }

    operator fun plus(lottoTicket: LottoTicket) {
        this.lottoTicket.addAll(lottoTicket.lottoTicket)
    }

    override fun toString(): String {
        return "${this.lottoTicket.joinToString("\n")}"
    }
}
