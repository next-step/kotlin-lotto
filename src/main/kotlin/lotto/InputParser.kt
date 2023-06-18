package lotto

import lotto.domain.LottoNumber

object InputParser {

    private const val SEPERATOR = ","
    fun parseInputStringToInt(inputString: String?): Int? {
        runCatching {
            return inputString?.toIntOrNull() ?: throw IllegalArgumentException("입력값은 숫자이어야함")
        }.getOrElse {
            it.printStackTrace()
            return null
        }
    }

    fun parseLotteryNumbers(winNumbers: String): List<LottoNumber> {
        require(winNumbers.isNotEmpty()) {
            "입력값은 비어있으면 안됨"
        }
        return winNumbers.split(SEPERATOR).map {
            val number = it.trim().toIntOrNull() ?: throw IllegalArgumentException("입력값은 숫자이어야함")
            LottoNumber(number)
        }
    }
}
