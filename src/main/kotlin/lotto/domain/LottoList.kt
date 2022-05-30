package lotto.domain

class LottoList(private val lottoList: List<LottoNumbers>) {
    val size = lottoList.size

    fun calculateGrade(winningNumbers: WinningNumbers): GradeInfos {
        return GradeInfos(
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
