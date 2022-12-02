package lotto.domain

import lotto.domain.lotto.LottoNumber

object AutoLotto : LottoFactory {

    override fun create() =
        Lotto(
            NUMBER_RANGE.shuffled()
                .take(DRAWING_QUANTITY)
                .sorted()
                .map { LottoNumber(it) }
        )
}
