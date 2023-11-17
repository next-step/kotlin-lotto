package lotto.provider.budget

class MockBudgetProvider(private val budget: Int) : BudgetProvider {
    override fun provide(): Int = budget
}
