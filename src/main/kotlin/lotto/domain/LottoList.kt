package lotto.domain

data class LottoList(val lottoList: List<Lotto>) {
    val size = lottoList.size
    fun getResult(winningNumbers: WinningNumbers): LottoResultList {
        val result = mutableListOf<LottoRank>()
        for (lotto in lottoList) {
            result.add(lotto.getLottoResult(winningNumbers))
        }
        return LottoResultList(result)
    }
}
