package lotto.util

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

fun String.toLottoNumbers(delimiters: String): LottoTicket {
    return runCatching {
        LottoTicket(
            this.split(delimiters)
                .map { LottoNumber(it.toInt()) }
        )
    }.getOrThrow()
}
