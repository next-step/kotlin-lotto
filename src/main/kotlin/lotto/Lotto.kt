package lotto

data class Lotto(val lottoNumbers: LottoNumbers) {
    fun getLottoResult(winningNumbers: WinningNumbers): LottoRank {
        return when (lottoNumbers.getContainCount(winningNumbers)) {
            3 -> LottoRank.FOURTH
            4 -> LottoRank.THIRD
            5 -> LottoRank.SECOND
            6 -> LottoRank.FIRST
            else -> LottoRank.NONE
        }
    }
}
