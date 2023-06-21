package lotto.domain.extension

import lotto.domain.Lotto
import lotto.domain.LottoNumbers

fun lotto(vararg numbers: Int) = Lotto(LottoNumbers.from(numbers.toSet()))
