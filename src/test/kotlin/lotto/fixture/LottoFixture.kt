package lotto.fixture

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.WinningLotto

fun createLotto(vararg numbers: Int): Lotto = Lotto.manualCreate(numbers.toList())

fun createWinningLotto(bonusNumber: Int, vararg numbers: Int): WinningLotto {
    return WinningLotto(Lotto.manualCreate(numbers.toList()), LottoNumber.create(bonusNumber))
}

fun createLottos(numbers: List<List<Int>>): Lottos {
    val lottos = buildList {
        numbers.forEach {
            add(Lotto.manualCreate(it))
        }
    }
    return Lottos(lottos)
}
