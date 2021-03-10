package lotto.view.request

import lotto.domain.LottoNumber

data class WinningNumberRequest(
    val numbers: String
) {
    fun toNumbers(): List<LottoNumber> {
        return numbers.split(delimiters = *arrayOf(","))
            .map { it.trim().toInt() }
            .map { LottoNumber.of(it) }
    }
}
