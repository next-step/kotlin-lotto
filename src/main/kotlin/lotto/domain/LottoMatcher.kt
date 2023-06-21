package lotto.domain

import lotto.dto.LottoResponse

class LottoMatcher {

    fun count(winningNumber: WinningNumber, lottoResponse: LottoResponse): Int {
        var matchedLottoCount = 0
        val winningLottoNumber = winningNumber.getWinningLottoNumber()
        lottoResponse.lottoNumbers.map {
            if (LottoNumberComparator.compare(winningLottoNumber, it))
                matchedLottoCount++
        }
        return matchedLottoCount
    }
}
