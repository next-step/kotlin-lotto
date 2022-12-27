package lotto.domain

data class LottoTicket(
    val numbers: Set<Int> = LottoNumberSelector.select(),
) : Set<Int> by numbers
