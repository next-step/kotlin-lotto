package lotto.domain

data class LottoWinningNumbers(
    val lottoNumbers: LottoNumbers,
    val bonusNumber: Int,
) {
    init {
        require(bonusNumber !in lottoNumbers.numbers) { "보너스 번호와 로또 번호에 중복된 수가 있으면 안됩니다." }
        require(LottoNumbers.inValidRange(bonusNumber)) { "유효하지 않은 보너스 번호 입니다." }
    }

    fun numberOfOverlaps(otherNumbers: LottoNumbers): Int {
        return lottoNumbers.numbers.count {
            it in otherNumbers.numbers
        }
    }

    fun isSecondPlace(otherNumbers: LottoNumbers): Boolean {
        if (numberOfOverlaps(otherNumbers) != Rank.SECOND.countOfMatch) return false

        return otherNumbers.numbers.all {
            it in lottoNumbers.numbers || it == bonusNumber
        }
    }
}
