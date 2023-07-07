package lotto.domain

class LottoWinningNumbers(
    val winningNumbers: LottoNumbers,
    val bonusNumber: LottoNumber
) {

    init {
        require(!winningNumbers.lottoNumbers.contains(bonusNumber)) { "로또번호와 보너스 번호는 중복될 수 없습니다." }
    }

    fun match(lottoNumbers: LottoNumbers): LottoMatchCount {
        val matchCount = lottoNumbers.getMatchCount(winningNumbers)
        val containsBonusNumber = lottoNumbers.containsBonusNumber(bonusNumber)

        return LottoMatchCount(matchCount = matchCount, containsBonusNumber = containsBonusNumber)
    }

    companion object {

        fun of(winningNumbers: List<Int>, bonusNumber: Int): LottoWinningNumbers {
            val lottoBonusNumber = LottoNumber(bonusNumber)
            return LottoWinningNumbers(
                winningNumbers = LottoNumbers.of(winningNumbers.map { LottoNumber(it) }),
                bonusNumber = lottoBonusNumber
            )
        }
    }
}
