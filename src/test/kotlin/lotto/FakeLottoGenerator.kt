package lotto

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.Number

class FakeLottoGenerator : LottoGenerator {
    override fun generate(size: Int): Lotto = Lotto(List(size) { 1 }.map { Number(it) })
}
