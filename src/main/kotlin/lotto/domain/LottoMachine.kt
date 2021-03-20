package lotto.domain

object LottoMachine {
    fun buy(buyingLotto: BuyingLotto): LottoTicket {
        val automaticLotto = dispenseAuto(buyingLotto.automaticCount)

        return LottoTicket(
            manuals = buyingLotto.manualLotto,
            automatics = automaticLotto
        )
    }

    private fun dispenseAuto(count: LottoCount): List<Lotto> {
        return (1..count.value).map { Lotto.create() }
    }
}
