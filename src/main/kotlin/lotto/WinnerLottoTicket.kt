package lotto

import java.lang.Exception

interface WinnerLottoTicket {
    val winnerLottoNumbers: Set<LottoNumber>
    fun countMatchNumber(lottoNumber: Set<LottoNumber>): Int = throw Exception()
}
