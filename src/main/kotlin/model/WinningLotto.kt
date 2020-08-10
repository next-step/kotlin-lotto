package model

import kotlin.properties.Delegates

class WinningLotto(override val number: List<LottoNumber>) : BasicLotto {
    var bonusNumber by Delegates.notNull<Int>()

    constructor(number: List<LottoNumber>, bonusNumber: Int) : this(number) {
        this.bonusNumber = bonusNumber
    }

    constructor(lotto: Lotto) : this(lotto.number)

    fun match(value: Lotto): Pair<Int, Boolean> {
        return number.count { value.number.contains(it) } to value.number.contains(LottoNumber.from(bonusNumber))
    }

    fun rank(value: Lotto): Rank {
        val matchResult = match(value)
        return Rank.valueOf(matchResult.first, matchResult.second)
    }
}
