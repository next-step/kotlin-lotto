package model

import kotlin.properties.Delegates

class WinningLotto(override val number: List<LottoNumber>) : BasicLotto {
    private var bonusNumber by Delegates.notNull<Int>()

    constructor(number: List<LottoNumber>, bonusNumber: Int) : this(number) {
        this.bonusNumber = bonusNumber
    }

    fun matchCount(value: Lotto): Int {
        return number.count { value.number.contains(it) }
    }
}
