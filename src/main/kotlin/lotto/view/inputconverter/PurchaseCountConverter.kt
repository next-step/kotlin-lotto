package lotto.view.inputconverter

import lotto.domain.model.PurchaseCount
import lotto.domain.model.UserInputResult

object PurchaseCountConverter : InputConverter<PurchaseCount> {
    override fun convert(input: String?): UserInputResult<PurchaseCount> {
        return input?.toIntOrNull()?.let { purchaseCount ->
            UserInputResult.Success(PurchaseCount.from(purchaseCount))
        } ?: UserInputResult.Failed
    }
}
