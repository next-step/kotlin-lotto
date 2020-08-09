package lotto.model.lotto

class Numbers(private val _list: List<LottoNumber>) {
    init {
        validation()
    }

    val list
        get() = _list

    val size = _list.size

    fun getMatchingCounts(compareNumbers: Numbers) = _list.sumBy { compareNumbers.matchCount(it) }

    fun isMatch(number: LottoNumber) = _list.contains(number)

    private fun matchCount(number: LottoNumber) = if (isMatch(number)) 1 else 0

    private fun validation() {
        require(_list.distinct().size == Lotto.NUMBER_COUNT) { "Lotto's NUMBER_COUNT 와 다릅니다." }
    }
}

internal fun String.toNumbers() = Numbers(this.split(",").map(String::toLottoNumber))
