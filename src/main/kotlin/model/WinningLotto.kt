package model

class WinningLotto(val lotto: Lotto, var bonusNumber: LottoNumber) : BasicLotto {
    constructor(number: Set<LottoNumber>, bonusNumber: Int) : this(Lotto(number), LottoNumber.from(bonusNumber))
    constructor(lotto: Lotto, bonusNumber: Int) : this(lotto, LottoNumber.from(bonusNumber))

    fun rank(lotto: Lotto): Rank {
        val matchCount = this.lotto.number.count { lotto.isIn(it) }
        val matchBonus = lotto.isIn(bonusNumber)
        return Rank.valueOf(matchCount, matchBonus)
    }

    override val number: Set<LottoNumber>
        get() = lotto.number
}
