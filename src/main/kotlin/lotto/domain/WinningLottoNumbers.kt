package lotto.domain

data class WinningLottoNumbers(private val lottoNumbers: LottoNumbers) {
    fun getAllNumberOfMatches(lotteries: List<LottoNumbers>): List<Int> {
        return lotteries.map {
            lottoNumbers.getNumberOfMatch(it)
        }
    }
}
