package lotto.machine

import lotto.Lotto
import lotto.LottoNumber
import lotto.Order

class ManualMachine : LottoMachine {
    override fun generate(order: Order): List<Lotto> {
        return order.lottoNumbers.map { lottoNumbers -> Lotto(lottoNumbers.map { LottoNumber.of(it) }) }
    }
}
