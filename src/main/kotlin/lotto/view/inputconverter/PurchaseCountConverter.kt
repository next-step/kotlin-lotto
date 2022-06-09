package lotto.view.inputconverter

import lotto.domain.model.PurchaseCount

object PurchaseCountConverter : InputConverter<PurchaseCount> {
    override fun convert(input: String): PurchaseCount {
        return PurchaseCount.from(input.toInt())
    }
}
