package lotto.domain

data class LottoTicket(
    val numbers: Set<LottoNumber> = LottoNumberSelector.select(),
) : Set<LottoNumber> by numbers
