package lotto.view.inputconverter

import lotto.domain.model.Money
import lotto.domain.model.UserInputResult

object MoneyConverter : InputConverter<Money> {
    override fun convert(input: String?): UserInputResult<Money> {
        val money = input?.toIntOrNull()

        return if (money != null && money > 0) {
            UserInputResult.Success(Money.from(money))
        } else {
            UserInputResult.Failed
        }
    }
}
