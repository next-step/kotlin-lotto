package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoWinningNumbers
import lotto.domain.LottoResult
import lotto.domain.Lottos

class LottoManager {

    fun buyLotto(price: Int): Lottos {
        return LottoMachine().buy(price)
    }

    fun getResult(lottos: Lottos, winningNumbers: LottoWinningNumbers): LottoResult {
        return lottos.getLottoResult(winningNumbers)
    }
}
