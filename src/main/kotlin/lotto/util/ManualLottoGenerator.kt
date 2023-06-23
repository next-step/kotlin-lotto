package lotto.util

import lotto.domain.Lotto
import lotto.domain.LottoNumber

class ManualLottoGenerator(private val lottoNumbersGenerator: () -> List<LottoNumber>) : LottoGenerator {

    override fun getLotto(): Lotto = Lotto(lottoNumbersGenerator().toSortedSet())
}
