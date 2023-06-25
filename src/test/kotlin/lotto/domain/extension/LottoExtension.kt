package lotto.domain.extension

import lotto.domain.Lotto
import lotto.domain.LottoNumbers
import lotto.domain.LottoType

fun lotto(vararg numbers: Int) = Lotto(numbers = LottoNumbers.from(numbers.toSet()), type = LottoType.MANUAL)
