package lotto

object InputValidator {

    private const val SEPERATOR = ","
    fun getBuyAmount(moneyString: String): Int {
        return moneyString.toIntOrNull() ?: throw IllegalArgumentException("구매금액은 숫자이어야함")
    }

    fun canBuyLotto(money: Int): Boolean {
        return money >= 1000
    }

    fun parseWinNumbers(winNumbers: String?): List<Int> {
        if(winNumbers.isNullOrEmpty()) {
            throw IllegalArgumentException("입력값은 비어있으면 안됨")
        }
        return winNumbers.split(SEPERATOR).map {
            it.toIntOrNull() ?: throw IllegalArgumentException("입력값은 숫자이어야함")
        }
    }
}
