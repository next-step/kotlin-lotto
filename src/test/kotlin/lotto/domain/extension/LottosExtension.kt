package lotto.domain.extension

import lotto.domain.Lotto
import lotto.domain.Lottos

fun lottos(vararg lottos: Lotto): Lottos = Lottos.from(lottos.toList())
