package lotto

import lotto.domain.Lotto
import lotto.domain.Lottos

class RawLottoNumbers(private val values: List<List<Int>> = emptyList()) {
    val size = values.size

    fun toLottos() = Lottos(values.map { Lotto(*it.toIntArray()) })
}
