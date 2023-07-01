package lotto.helper

import lotto.domain.LottoNumbers

object LottoNumbersHelper {

    fun generate(vararg number: Int): LottoNumbers {
        return LottoNumbers.of(number.toList())
    }
}
