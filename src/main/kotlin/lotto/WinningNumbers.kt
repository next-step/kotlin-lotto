package lotto

class WinningNumbers(private val lottoNumbers: LottoNumbers, private val bonusNumber: LottoNumber) {
    init {
        require(!lottoNumbers.numbers.contains(bonusNumber)) { INVALID_BONUS_NUMBER_MESSAGE }
    }

    fun calculateRank(lottoNumbers: List<LottoNumbers>): List<Rank> {
        return lottoNumbers.map { calculateRank(it) }
    }

    fun calculateRank(other: LottoNumbers): Rank {
        val matchedCount = other.match(lottoNumbers)
        val matchBonus = other.contains(bonusNumber)

        return Rank.from(matchedCount, matchBonus)
    }

    companion object {
        const val INVALID_BONUS_NUMBER_MESSAGE = "보너스 번호는 당첨 번호에 포함되지 않은 번호여야 합니다."
    }
}
