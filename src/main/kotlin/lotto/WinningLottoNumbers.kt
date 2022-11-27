package lotto

class WinningLottoNumbers(private val winningLottoNumbers: List<LottoNumber>) {

    fun win(inputLottoNumbers: LottoNumbers): Int {
        return inputLottoNumbers.contains(winningLottoNumbers = winningLottoNumbers)
    }

    override fun toString(): String {
        return "$winningLottoNumbers"
    }
}
