package lotto.model

class Numbers(private val _list: List<Int>) {
    init {
        validation()
    }

    val list
        get() = _list

    val size = _list.size

    private fun validation() {
        require(_list.size == Lotto.NUMBER_COUNT) { "Lotto's NUMBER_COUNT 와 다릅니다." }
    }

    fun getMatchingCounts(compareNumbers: Numbers) = _list.sumBy { compareNumbers.matchCount(it) }

    private fun matchCount(number: Int) = if (isMatch(number)) 1 else 0

    private fun isMatch(number: Int) = _list.contains(number)
}

internal fun String.toNumbers() = Numbers(this.split(",").map(String::toInt))
