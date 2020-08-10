package lotto.model.lotto

class Numbers(private val _list: Set<LottoNumber>) {
    init {
        validation()
    }

    val list
        get() = _list

    val size = list.size

    fun isMatch(number: LottoNumber) = list.contains(number)

    fun getMatchingCounts(compareNumbers: Numbers) = list.sumBy { compareNumbers.matchCount(it) }

    private fun matchCount(number: LottoNumber) = if (isMatch(number)) 1 else 0

    private fun validation() {
        require(_list.size == Lotto.NUMBER_COUNT) { "Lotto's NUMBER_COUNT 와 다릅니다." }
    }
}

internal fun String.toNumbers() = Numbers(this.split(",").map { LottoNumber.from(it) }.toSet())
