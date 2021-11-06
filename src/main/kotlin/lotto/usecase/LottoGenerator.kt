package lotto.usecase

import lotto.domain.Lotto
import lotto.domain.model.LottoNumbers
import lotto.domain.model.Price

class LottoGenerator : Generator {

    override fun generate(
        numbers: LottoNumbers,
        price: Price,
    ): Lotto {
        return Lotto(
            numbers = numbers,
            price = price
        )
    }
}
