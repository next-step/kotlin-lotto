package lotto.domain

class WinningLotto(private val winningLottoNumbers: List<LottoNumber>, private val bonusNumber: LottoNumber) {

    init {
        require(winningLottoNumbers.size == VALID_WINNING_LOTTO_NUMBER_COUNT) { "로또번호 개수가 ${VALID_WINNING_LOTTO_NUMBER_COUNT}개가 아닙니다." }
        require(hasNotDuplicatedLottoNumber(winningLottoNumbers)) { "중복된 로또번호가 있습니다." }
        require(!winningLottoNumbers.contains(bonusNumber)) { "당첨번호 중에 보너스번호가 존재할 수 없습니다." }
    }

    private fun hasNotDuplicatedLottoNumber(lottoNumbers: List<LottoNumber>): Boolean {
        return lottoNumbers.distinct().size == VALID_WINNING_LOTTO_NUMBER_COUNT
    }

    fun calculateLottoPrize(lotto: Lotto): LottoPrize {
        val matchedCount = matchLottoNumberCount(lotto)
        val hasBonusNumber = lotto.hasNumber(bonusNumber)
        return LottoPrize.valueOf(matchedCount, hasBonusNumber)
    }

    private fun matchLottoNumberCount(lotto: Lotto): Int {
        val lottoNumbers = lotto.lottoNumbers
        return winningLottoNumbers.intersect(lottoNumbers).size
    }

    companion object {
        private const val VALID_WINNING_LOTTO_NUMBER_COUNT = 6
    }
}
