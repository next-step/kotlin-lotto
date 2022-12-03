package lotto.domain

class LottoTicket(
    lottoGenerateStrategy: LottoGenerateStrategy,
    val lottoNumbers: Set<LottoNumber> = lottoGenerateStrategy.generate()
) : Set<LottoNumber> by lottoNumbers
