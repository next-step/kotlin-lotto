package lotto.domain

interface LottoMachine {
    fun generateAuto(): LottoTicket

    fun generateManual(lottoNumbers: List<LottoNumber>): LottoTicket
}
