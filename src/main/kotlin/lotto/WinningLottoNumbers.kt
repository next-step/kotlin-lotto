package lotto

class WinningLottoNumbers(private val winningLottoNumbers: Set<LottoNumber>) {

    fun win(inputLottoNumbers: LottoNumbers): Int {
        return inputLottoNumbers.contains(winningLottoNumbers = winningLottoNumbers)
    }

    override fun toString(): String {
        return "$winningLottoNumbers"
    }
}
