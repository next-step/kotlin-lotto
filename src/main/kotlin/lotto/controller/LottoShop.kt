package lotto.controller

import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.numberGenerator.FixedLottoNumberGenerator

class LottoShop(private val lottoFactory: LottoFactory) {

    fun purchaseLottos(ticket: LottoTicket): Lottos {
        val manualLottos = ticket.manualLottoNumbers.map {
            val numberGenerator = FixedLottoNumberGenerator(it)
            LottoNumbers(numberGenerator.generateNumbers())
        }

        val randomLottos = lottoFactory.createRandomLottos(ticket.numberOfRandomLottos)

        return Lottos(manualLottos) + randomLottos
    }
}
