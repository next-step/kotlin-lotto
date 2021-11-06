package lotto.usecase

import lotto.domain.Lotto
import lotto.domain.model.LottoNumber
import lotto.domain.model.LottoNumbers
import lotto.domain.model.Price

class LottoGenerator : Generator {

    override fun generate(
        numbers: List<LottoNumber>,
        price: Price,
    ): Lotto {
        return Lotto(
            numbers = LottoNumbers(numbers),
            price = price
        )
    }
}
