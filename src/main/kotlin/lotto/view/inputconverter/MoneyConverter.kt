package lotto.view.inputconverter

import lotto.domain.model.Money

object MoneyConverter : InputConverter<Money> {
    override fun convert(input: String): Money = Money.from(input.toInt())
}
