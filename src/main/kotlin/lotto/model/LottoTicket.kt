package lotto.model

private val LOTTO_NUMBER_RANGE = 1..45
private val LOTTO_NUMBERS = LOTTO_NUMBER_RANGE.toList()

class LottoTicket(private val lottoTicket: List<Lotto>) {

    fun gameResult(winningLotto: Lotto, bonus: LottoNumber): GameResults {
        return GameResults(lottoTicket.map { it.rank(winningLotto, bonus) })
    }

    operator fun plus(lottoTicket: LottoTicket): LottoTicket {
        this.lottoTicket.toMutableList().addAll(lottoTicket.lottoTicket)
        return LottoTicket(this.lottoTicket)
    }

    override fun toString(): String {
        return "${this.lottoTicket.joinToString("\n")}"
    }

    companion object {
        fun createRandomLotto(count: Int): LottoTicket {
            val lottoList = mutableListOf<Lotto>()
            repeat(count) {
                lottoList.add(Lotto(LOTTO_NUMBERS.shuffled().take(6).sorted().map { LottoNumber.from(it) }))
            }
            return LottoTicket(lottoList)
        }
    }
}
