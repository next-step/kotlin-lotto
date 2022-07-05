package lotto.service

import lotto.domain.LottoNumber

object InputParser {

    fun parsePurchaseAmount(input: String): Int {
        return input.toInt()
    }

    fun parseManualAmount(input: String): Int {
        return input.toInt()
    }

    fun parseLottoNumbers(input: String): List<LottoNumber> {
        val numbers = input.split(", ")

        val lottoNumbers = numbers.map { it.toInt() }.map(LottoNumber::of)

        return lottoNumbers
    }

    fun parseBonusNumber(input: String): LottoNumber {
        val bonusNumber = input.toInt()

        return LottoNumber.of(bonusNumber)
    }
}
