package lotto.extension

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoType

fun Lotto.Companion.manualOf(vararg numbers: Int): Lotto = Lotto(LottoType.MANUAL, numbers.map { LottoNumber(it) })

fun Lotto.Companion.autoOf(vararg numbers: Int): Lotto = Lotto(LottoType.AUTO, numbers.map { LottoNumber(it) })
