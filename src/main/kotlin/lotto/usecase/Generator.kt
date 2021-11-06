package lotto.usecase

import lotto.domain.Lotto
import lotto.domain.model.LottoNumber
import lotto.domain.model.Price

interface Generator {
    fun generate(
        numbers: List<LottoNumber>,
        price: Price,
    ): Lotto
}
