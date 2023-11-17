package lotto.provider.budget

class UserInputBudgetProvider : BudgetProvider {
    override fun provide(): Int = println("구입 금액을 입력하세요")
        .run {
            readln().trim().toInt()
        }
}
