package lotto.domain

object LottoMachine {
    fun buy(price: LottoPrice, manualNumbers: ManualNumbers): LottoTicket {
        val manualLottos: List<Lotto> = dispenseManual(manualNumbers)
        val automaticLottos: List<Lotto> = dispenseAuto(price.calculateAutomaticCount(manualLottos.size))

        val ticket = LottoTicket(
            manuals = manualLottos,
            automatics = automaticLottos
        )

        buyingValidate(price, ticket)

        return ticket
    }

    private fun buyingValidate(price: LottoPrice, lottoTicket: LottoTicket) {
        require(price.isExceedPriceByCount(lottoTicket.totalLottoCount())) {
            "로또 구매수는 구입금액을 초과할 수 없습니다."
        }
    }

    private fun dispenseAuto(count: Int): List<Lotto> {
        return (1..count).map { Lotto.create() }
    }

    private fun dispenseManual(manualNumbers: ManualNumbers): List<Lotto> {
        return manualNumbers.toLottos()
    }
}
