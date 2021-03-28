package lotto.domain

data class LottoTickets(private val lottoTickets: List<LottoTicket>) : List<LottoTicket> by lottoTickets {
    constructor(count: Int, generator: LottoNumberGenerator = LottoNumberRandomGenerator()) : this(
        createLotto(
            count,
            generator
        )
    )

    constructor(
        autoCount: Int,
        manualLottoTickets: LottoTickets,
        generator: LottoNumberGenerator = LottoNumberRandomGenerator()
    ) : this(
        createLotto(
            autoCount,
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
