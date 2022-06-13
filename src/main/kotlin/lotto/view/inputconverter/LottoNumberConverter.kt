package lotto.view.inputconverter

import lotto.domain.model.LottoNumber
import lotto.domain.model.UserInputResult

object LottoNumberConverter : InputConverter<LottoNumber> {
    override fun convert(input: String?): UserInputResult<LottoNumber> {
        return if (input?.toIntOrNull() in LottoNumber.LOTTO_NUMBER_RANGE) {
            UserInputResult.Success(LottoNumber[input!!.toInt()])
        } else UserInputResult.Failed
    }
}
