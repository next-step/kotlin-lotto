package lotto.usecase

import lotto.domain.Lotto
import lotto.domain.model.LottoNumbers
import lotto.domain.model.Price

interface Generator {
    fun generate(
        numbers: LottoNumbers,
        price: Price,
    ): Lotto
}
