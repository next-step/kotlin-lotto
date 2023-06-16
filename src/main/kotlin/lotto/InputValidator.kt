package lotto

object InputValidator {
    fun parseAmount(moneyString: String): Int {
        return moneyString.toIntOrNull() ?: throw IllegalArgumentException("구매금액은 숫자이어야함")
    }

    fun canBuyLotto(money: Int): Boolean {
        return money >= 1000
    }
}
