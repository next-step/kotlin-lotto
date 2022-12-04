package lotto

class WinningLottoNumbers(private val winningLottoNumbers: Set<LottoNumber>) {

    fun win(inputLottoNumbers: LottoNumbers, bonusLottoNumber: BonusNumber): Rank {
        val contains = inputLottoNumbers.contains(winningLottoNumbers = winningLottoNumbers)
        val isBonus = inputLottoNumbers.contain(bonusLottoNumber.lottoNumber)
        if (contains == 5 && isBonus.not())
            return Rank.THIRD
        return Rank.findByFirst(contains)
    }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return this.winningLottoNumbers.contains(lottoNumber)
    }

    override fun toString(): String {
        return "$winningLottoNumbers"
    }
}
