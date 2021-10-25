package lotto.utils

import lotto.domain.LottoNumber

object StringUtils {

    fun toLottoNumbers(text: String): List<LottoNumber> {
        val split = text.split(DELIMITER)
        return split.map { LottoNumber.valueOf(toNumber(it)) }
    }

    fun toNumber(text: String): Int {
        return Integer.parseUnsignedInt(text)
    }

    private const val DELIMITER = ","
}
