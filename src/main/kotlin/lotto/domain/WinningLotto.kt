package lotto.domain

class WinningLotto(private val lottoNumbers: LottoNumbers, private val bonusNumber: LottoNumber) {
    init {
        if (bonusNumber in lottoNumbers) {
            throw WinningLottoNumbersAndBonusNumberDuplicationException(lottoNumbers, bonusNumber)
        }
    }

    fun calculateMatchCount(userLotto: Lotto): Int {
        return userLotto.calculateMatchCount(lottoNumbers)
    }

    fun containsBonusNumberIn(lotto: Lotto): Boolean {
        return lotto.contains(bonusNumber)
    }
}
