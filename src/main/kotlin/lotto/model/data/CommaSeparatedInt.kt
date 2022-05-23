package lotto.model.data

import lotto.util.parseToInt

class CommaSeparatedInt(string: String?) {

    private val parsedIntList = (string ?: "")
        .split(",")
        .map { it.parseToInt() }

    val firstError: Throwable?
        get() = (this.parsedIntList.find { it is ParseResult.Error } as? ParseResult.Error)
            ?.error

    fun toLottoNumbers() = LottoNumbers(
        this.toIntList().map { LottoNumber(it) }
    )

    private fun toIntList() = this.parsedIntList
        .mapNotNull { if (it is ParseResult.Value<Int>) it.value else null }
}
