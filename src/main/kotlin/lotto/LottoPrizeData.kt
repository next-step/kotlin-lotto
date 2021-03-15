package lotto

class LottoPrizeData(val matchCount: Int, val prizeMoney: Int, val includeBonusNumber: Boolean) {
    constructor(matchCount: Int, prizeMoney: Int) : this(matchCount, prizeMoney, false)
}
