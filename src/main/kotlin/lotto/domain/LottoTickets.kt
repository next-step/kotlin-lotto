package lotto.domain

class LottoTickets(private val lottoTickets: List<LottoTicket>) : List<LottoTicket> by lottoTickets {
    constructor(count: Int, generator: LottoNumberGenerator = LottoNumberRandomGenerator()) : this(
        createLotto(
            count,
            generator
        )
    )

    constructor(count: Int, manualLottoTickets: LottoTickets, generator: LottoNumberGenerator = LottoNumberRandomGenerator()) : this(
        createLotto(
            count - manualLottoTickets.size,
            generator
        ) + manualLottoTickets
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
