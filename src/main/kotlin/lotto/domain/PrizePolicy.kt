package lotto.domain

interface PrizePolicy<LottoTicket, PrizeType> {
    fun won(lottoTicket: LottoTicket): PrizeType
}
