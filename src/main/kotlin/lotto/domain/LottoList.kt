package lotto.domain

class LottoList(private val lottoList: List<LottoNumbers>) {
    val size = lottoList.size

    fun calculateLottoResult(winningNumbers: WinningNumbers): LottoResult {
        return LottoResult(
            lottoList.map {
                val count = it.calculateWinningCount(winningNumbers.numbers)
                Grade.valueOf(count)
            }
        )
    }

    fun forEach(action: (LottoNumbers) -> Unit) {
        lottoList.forEach(action)
    }
}
