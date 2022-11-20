package lotto

interface WinnerLottoTicket {
    val winnerLottoNumbers: Set<LottoNumber>
    fun countMatchNumber(lottoNumber: Set<LottoNumber>): Int = lottoNumber.intersect(winnerLottoNumbers).size
}
