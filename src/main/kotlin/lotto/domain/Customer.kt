package lotto.domain

class Customer(money: String) {
    val money: Int

    init {
        require(validations.all { it.invoke(money) })
        this.money = money.toInt()
    }

    companion object {
        private val isDigit: (String) -> Boolean = { it.all { char -> char.isDigit() } }
        private val isDivisibleByThousand: (String) -> Boolean = { it.toInt() % 1000 == 0 }

        private val validations = listOf(isDigit, isDivisibleByThousand)
    }
}
