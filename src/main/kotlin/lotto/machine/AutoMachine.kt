package lotto.machine

import lotto.Lotto
import lotto.LottoNumber
import lotto.Order

class AutoMachine : LottoMachine {
    override fun generate(order: Order): List<Lotto> {
        return List(order.autoTicketNumber) { Lotto(LottoNumber.all().shuffled().take(LOTTO_NUMBER_COUNT)) }
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
