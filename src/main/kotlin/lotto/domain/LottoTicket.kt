package lotto.domain

data class LottoTicket(
    val numbers: Set<LottoNumber>,
) : Set<LottoNumber> by numbers
