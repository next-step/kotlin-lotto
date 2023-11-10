package lotto.domain

class Customer(val money: Int) {

    companion object {
        private val isDigit: (String) -> Boolean = { it.all { char -> char.isDigit() } }

        fun valueOf(money: String): Customer {
            require(isDigit(money))
            return Customer(money.toInt())
        }
    }
}
