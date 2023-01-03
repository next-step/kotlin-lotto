package lotto.domain

object Store {
    fun purchaseAutoLottos(ticket: Ticket): Lottos {
        return issueLottos(ticket.autoLottoSize)
    }

    fun purchaseManualLotto(ticket: Ticket): Lottos {
        return Lottos(
            ticket.manualLottoNumbers.map {
                Lotto(
                    it.map(LottoNumber::of).toSet()
                )
            }
        )
    }

    private fun issueLottos(count: Int): Lottos {
        return Lottos(
            List(count) { LottoGenerator.generate() }
        )
    }
}
