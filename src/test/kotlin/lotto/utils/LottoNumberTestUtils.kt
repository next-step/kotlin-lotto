package lotto.utils

import lotto.domain.LottoNumber

object LottoNumberTestUtils {
    fun lottoNumbers(vararg numbers: Long): Set<LottoNumber> {
        return numbers
            .map { LottoNumber(it) }
            .toSet()
    }
}
