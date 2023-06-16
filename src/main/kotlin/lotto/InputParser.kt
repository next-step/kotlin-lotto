package lotto

object InputParser {

    private const val SEPERATOR = ","
    fun getBuyAmount(moneyString: String): Int {
        return moneyString.toIntOrNull() ?: throw IllegalArgumentException("구매금액은 숫자이어야함")
    }

    fun parseWinNumbers(winNumbers: String?): List<Int> {
        require(!winNumbers.isNullOrEmpty()) {
            "입력값은 비어있으면 안됨"
        }
        return winNumbers.split(SEPERATOR).map {
            it.trim().toIntOrNull() ?: throw IllegalArgumentException("입력값은 숫자이어야함")
        }
    }
}
