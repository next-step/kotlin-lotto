package lotto.model.data

import lotto.util.parseToInt

class CommaSeparatedInt(string: String?) {
    val string = string ?: ""

    val parsedIntList = this.string
        .split(",")
        .map { it.parseToInt() }

    val firstError: Throwable?
        get() = (this.parsedIntList.find { it is ParseResult.Error } as? ParseResult.Error)
            ?.error

    val hasError: Boolean
        get() = this.firstError != null

    fun toIntList() = this.parsedIntList
        .mapNotNull { if (it is ParseResult.Value<Int>) it.value else null }

    fun toLottoNumbers() = LottoNumbers(
        this.toIntList().map { LottoNumber(it) }
    )
}
