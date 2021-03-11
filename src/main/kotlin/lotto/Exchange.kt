package lotto

interface Exchange<ProductT> {
    fun pay(money: Money)

    fun product(): List<ProductT>

    class Lotto(private val lottoDrawMachine: LottoDrawMachine) : Exchange<LottoNumbers> {
        private lateinit var lottoTicket: LottoTicket
        override fun pay(money: Money) {
            lottoTicket = LottoTicket(money)
        }

        override fun product(): List<LottoNumbers> = (0 until lottoTicket.count)
            .map { lottoDrawMachine.lottoNumber() }
    }
}
