package lotto

class WinningNumbers(private val lottoNumbers: LottoNumbers, private val bonusNumber: LottoNumber) {
    fun calculateRank(lottoNumbers: List<LottoNumbers>): List<Rank> {
        return lottoNumbers.map { calculateRank(it) }
    }

    fun calculateRank(lottoNumbers: LottoNumbers): Rank {
        val intersection = this.lottoNumbers.numbers.intersect(lottoNumbers.numbers)
        val matchedCount = intersection.size

        return Rank.from(matchedCount)
    }
}
