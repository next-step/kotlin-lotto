package lotto.domain

class Bank(
    private var income: Int = 0
) {
    fun save(amount: Amount): Int {
        income += amount.value
        return income
    }
}
