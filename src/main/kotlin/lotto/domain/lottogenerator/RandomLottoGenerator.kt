package lotto.domain.lottogenerator

import lotto.domain.Lotto
import lotto.domain.LottoNumber

    fun generate(): Lotto {
        return Lotto(
            LottoNumber.RANGE.toList()
                .shuffled()
                .take(Lotto.SIZE)
                .map { LottoNumber.of(it) }
                .toSortedSet()
        )
    }
}
