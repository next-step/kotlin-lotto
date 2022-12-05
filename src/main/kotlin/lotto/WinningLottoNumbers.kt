package lotto

class WinningLottoNumbers(private val winningLottoNumbers: Set<LottoNumber>) {

    fun win(inputLottoNumbers: LottoNumbers, bonusLottoNumber: BonusNumber): Rank {
        val contains = inputLottoNumbers.match(winningLottoNumbers = winningLottoNumbers)
        val isBonus = inputLottoNumbers.contain(bonusLottoNumber.lottoNumber)
        if (contains == Rank.SECOND && isBonus.not())
            return Rank.THIRD
        return contains
    }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return this.winningLottoNumbers.contains(lottoNumber)
    }

    override fun toString(): String {
        return "$winningLottoNumbers"
    }
}
