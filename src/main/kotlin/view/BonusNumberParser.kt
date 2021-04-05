package view

import domain.lotto.LottoNumber

object BonusNumberParser {
    fun parse(input: String, except: ParsedLottoNumbers): Int? {
        val integer = input.toIntOrNull() ?: return null

        if (integer !in LottoNumber.RANGE) {
            return null
        }

        if (except.contains(integer)) {
            return null
        }

        return integer
    }
}
