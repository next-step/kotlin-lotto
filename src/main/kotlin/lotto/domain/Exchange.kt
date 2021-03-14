package lotto.domain

interface Exchange<ProductT> {
    fun pay(money: Money, manualPick: List<LottoNumbers> = emptyList())

    fun product(): List<ProductT>

    class Lotto(private val lottoDrawMachine: LottoDrawMachine) : Exchange<LottoNumbers> {
        private lateinit var lottoTicket: LottoTicket
        private lateinit var manualPick: List<LottoNumbers>
        override fun pay(money: Money, manualPick: List<LottoNumbers>) {
            lottoTicket = LottoTicket(money)
            this.manualPick = manualPick
        }

        override fun product(): List<LottoNumbers> = (0 until lottoTicket.count - manualPick.size)
            .map { lottoDrawMachine.lottoNumber() } + manualPick
    }
}
