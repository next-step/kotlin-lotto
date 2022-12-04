package lotto.domain.strategy.bonus

import lotto.domain.LottoNumber

interface BonusGenerateStrategy {
    fun generate(): LottoNumber
}
