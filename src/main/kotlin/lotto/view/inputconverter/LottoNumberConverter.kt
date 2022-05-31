package lotto.view.inputconverter

import lotto.domain.model.LottoNumber

object LottoNumberConverter : InputConverter<LottoNumber> {
    override fun convert(input: String): LottoNumber {
        return LottoNumber[input.toInt()]
    }
}
