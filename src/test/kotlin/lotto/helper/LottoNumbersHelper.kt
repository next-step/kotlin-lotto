package lotto.helper

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

object LottoNumbersHelper {

    fun generate(vararg number: Int): LottoNumbers {
        val lottoNumbers = number.map { LottoNumber(it) }
        return LottoNumbers.of(lottoNumbers)
    }
}
