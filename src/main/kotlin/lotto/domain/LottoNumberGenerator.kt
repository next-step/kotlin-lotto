package lotto.domain

import lotto.domain.LottoTicket.Companion.LOTTO_NUMBER_COUNT
import lotto.domain.LottoTicket.Companion.LOTTO_NUMBER_MAX_VALUE
import lotto.domain.LottoTicket.Companion.LOTTO_NUMBER_MIN_VALUE

fun lottoNumberGenerator(): Set<Int> {
    return (LOTTO_NUMBER_MIN_VALUE..LOTTO_NUMBER_MAX_VALUE)
        .toSet().shuffled().take(LOTTO_NUMBER_COUNT).sorted().toSet()
}
