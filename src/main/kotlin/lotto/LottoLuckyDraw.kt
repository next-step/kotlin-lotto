package lotto

class LottoLuckyDraw(
    luckyNumberString: String
) {
    val luckyNumber = luckyNumberString.replace(" ", "").split(",").map { it.toInt() }
    val getStatistics
        get() = this._statistics

    private val _statistics = Statistics()

    fun doLuckDraw(lottoList: List<LottoNumber>) {
        lottoList.forEach {
            _statistics.plusCount(checkDrawResult(it))
        }
    }

    private fun checkDrawResult(lottoNumber: LottoNumber): Int {
        val numbers = lottoNumber.numbers
        var matchCount = 0
        luckyNumber.forEach {
            matchCount = numbers.isContainNumber(it, matchCount)
        }
        return matchCount
    }

    private fun List<Int>.isContainNumber(input: Int, matchCount: Int): Int =
        if (this.contains(input)) matchCount + 1 else matchCount
}

