package model

import kotlin.properties.Delegates

class WinningLotto(override val number: Set<LottoNumber>) : BasicLotto {
    var bonusNumber by Delegates.notNull<Int>()

    constructor(number: Set<LottoNumber>, bonusNumber: Int) : this(number) {
        this.bonusNumber = bonusNumber
    }

    constructor(lotto: Lotto, bonusNumber: Int) : this(lotto.number, bonusNumber)

    fun match(lotto: Lotto): Pair<Int, Boolean> {
        return number.count { lotto.isIn(it) } to lotto.isIn(LottoNumber.from(bonusNumber))
    }

    fun rank(value: Lotto): Rank {
        val matchResult = match(value)
        return Rank.valueOf(matchResult.first, matchResult.second)
    }
}
