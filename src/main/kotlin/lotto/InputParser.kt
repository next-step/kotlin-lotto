package lotto

import lotto.domain.LottoNumber

object InputParser {

    private const val SEPERATOR = ","
    fun getBuyAmount(moneyString: String): Int {
        return moneyString.toIntOrNull() ?: throw IllegalArgumentException("구매금액은 숫자이어야함")
    }

    fun parseWinNumbers(winNumbers: String): List<LottoNumber> {
        require(winNumbers.isNotEmpty()) {
            "입력값은 비어있으면 안됨"
        }
        return winNumbers.split(SEPERATOR).map {
            val number = it.trim().toIntOrNull() ?: throw IllegalArgumentException("입력값은 숫자이어야함")
            LottoNumber(number)
        }
    }

    fun parseBonus(bonusNumber: String): LottoNumber {
        val number = bonusNumber.toIntOrNull() ?: throw IllegalArgumentException("보너스볼은 숫자이어야함")
        return LottoNumber(number)
    }
}
