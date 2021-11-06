package lotto.usecase

import lotto.domain.Lotto
import lotto.domain.LottoNumber

interface Generator {
    fun generate(
        numbers: List<LottoNumber>,
        price: Int,
    ): Lotto
}
