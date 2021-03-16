package lotto.ticket

class WinningTicket(
    private val lottoNumbers: Set<LottoNumber>
) {
    fun matchNumber(lottoNumber: LottoNumber):Boolean{
        return lottoNumbers.contains(lottoNumber)
    }
}