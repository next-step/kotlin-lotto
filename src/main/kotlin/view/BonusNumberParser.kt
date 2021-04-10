package view

import domain.lotto.LottoNumber

object BonusNumberParser {
    fun parse(input: String, winningNumbers: ParsedLottoNumbers): Int? {
        val integer = input.toIntOrNull() ?: return null

        if (integer !in LottoNumber.RANGE) {
            return null
        }

        if (winningNumbers.contains(integer)) {
            return null
        }

        return integer
    }
}
