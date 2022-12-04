package lotto

class WinningLottoNumbers(private val winningLottoNumbers: Set<LottoNumber>) {

    fun win(inputLottoNumbers: LottoNumbers, bonusLottoNumber: LottoNumber): Rank {
        val contains = inputLottoNumbers.contains(winningLottoNumbers = winningLottoNumbers)
        val isBonus = inputLottoNumbers.contain(bonusLottoNumber)
        if (contains == 5 && isBonus.not())
            return Rank.THIRD
        return Rank.findByFirst(contains)
    }

    override fun toString(): String {
        return "$winningLottoNumbers"
    }
}
