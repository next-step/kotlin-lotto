package model

import kotlin.properties.Delegates

class WinningLotto(override val number: Set<LottoNumber>) : BasicLotto {
    var bonusNumber by Delegates.notNull<Int>()

    constructor(number: Set<LottoNumber>, bonusNumber: Int) : this(number) {
        this.bonusNumber = bonusNumber
    }

    constructor(lotto: Lotto, bonusNumber: Int) : this(lotto.number, bonusNumber)

    fun rank(lotto: Lotto): Rank {
        val matchCount = number.count { lotto.isIn(it) }
        val matchBonus = lotto.isIn(LottoNumber.from(bonusNumber))
        return Rank.valueOf(matchCount, matchBonus)
    }
}
