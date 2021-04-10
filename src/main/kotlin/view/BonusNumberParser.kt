package view

import domain.lotto.LottoNumber

object BonusNumberParser {
    fun parse(bonusNumberString: String, winningNumbers: ParsedLottoNumbers): Int? {
        val parsedBonusNumber = bonusNumberString.toIntOrNull() ?: return null

        if (parsedBonusNumber !in LottoNumber.RANGE) {
            return null
        }

        if (winningNumbers.contains(parsedBonusNumber)) {
            return null
        }

        return parsedBonusNumber
    }
}
