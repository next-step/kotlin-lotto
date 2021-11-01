package lotto.domain

import lotto.utils.StringUtils

object ManualNumberGenerator {

    fun generateNumbers(text: String): List<LottoNumber> {
        return StringUtils.toLottoNumbers(text)
    }
}
