package lotto.util

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.io.ResultView

class ManualLottoGenerator(private val lottoNumbersGenerator: () -> List<LottoNumber>) : LottoGenerator {

    override fun getLottos(count: Int): Lottos {
        ResultView.printManualLottoInputMessage()
        return super.getLottos(count)
    }

    override fun getLotto(): Lotto = Lotto(lottoNumbersGenerator().toSortedSet())
}
