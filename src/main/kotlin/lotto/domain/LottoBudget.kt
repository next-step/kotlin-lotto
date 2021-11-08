package lotto.domain

import lotto.domain.ExceptionType.BUDGET_UNSIGNED_INT

data class LottoBudget(private var budget: Int) {
    init {
        checkBudgetUnsigned()
    }

    constructor(stringValue: String) : this(stringValue.toValidatedUnsignedInt())

    fun getNumberOfGames() = budget / PRICE_OF_GAME

    fun getWinningRatio(fullWinnings: Int): Double {
        if (budget == 0)
            return 0.0
        return fullWinnings / budget.toDouble()
    }

    private fun checkBudgetUnsigned() = require(budget >= 0) { BUDGET_UNSIGNED_INT }

    companion object {
        fun String.toValidatedUnsignedInt(): Int {
            require(InputValidateChecker.isUnsignedInt(this)) { BUDGET_UNSIGNED_INT }
            return this.toInt()
        }

        const val PRICE_OF_GAME = 1000
    }
}
