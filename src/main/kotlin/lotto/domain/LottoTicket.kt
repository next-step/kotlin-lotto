package lotto.domain

class LottoTicket(
    val lottoNumbers: Set<LottoNumber>
) : Set<LottoNumber> by lottoNumbers
