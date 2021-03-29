package domain.winning

import domain.money.Money

data class IncomeExpenditureRatio(val value: Double) {
    init {
        require(value >= 0.0)
    }

    companion object {
        fun calculatedBy(income: Money, expenditure: Money): IncomeExpenditureRatio {
            require(expenditure > Money.ZERO)
            return IncomeExpenditureRatio(income.value.toDouble() / expenditure.value.toDouble())
        }
    }
}
