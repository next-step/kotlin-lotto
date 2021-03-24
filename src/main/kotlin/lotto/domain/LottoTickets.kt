package lotto.domain

class LottoTickets(private val lottoTickets: List<LottoTicket>) : List<LottoTicket> by lottoTickets {
    init {
        require(lottoTickets.isNotEmpty()) { "로또는 1개 이상을 갖고있어야 합니다." }
    }

    constructor(count: Int, generator: LottoNumberGenerator = LottoNumberRandomGenerator()) : this(
        createLotto(
            count,
            generator
        )
    )

    companion object {
        private fun createLotto(count: Int, generator: LottoNumberGenerator): List<LottoTicket> {
            val lottoTickets: MutableList<LottoTicket> = mutableListOf()

            repeat(count) {
                lottoTickets.add(LottoTicket(generator))
            }

            return lottoTickets.toList()
        }
    }
}
