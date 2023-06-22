package lotto.util

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.io.InputView
import lotto.io.ResultView

object ManualLottoGenerator : LottoGenerator {

    override fun getLottos(count: Int): Lottos {
        ResultView.printManualLottoInputMessage()
        return super.getLottos(count)
    }

    override fun getLotto(): Lotto {
        return Lotto(InputView.getManualLotto().map { LottoNumber(it) }.toSortedSet())
    }
}
