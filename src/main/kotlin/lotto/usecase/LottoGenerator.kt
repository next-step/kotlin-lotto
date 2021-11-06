package lotto.usecase

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

class LottoGenerator : Generator {

    override fun generate(
        numbers: List<LottoNumber>,
        price: Int,
    ): Lotto {
        return Lotto(
            numbers = LottoNumbers(numbers),
            price = price
        )
    }
}
