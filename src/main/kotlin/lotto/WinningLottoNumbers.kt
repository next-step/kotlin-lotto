package lotto

class WinningLottoNumbers(private var winningLottoNumbers: MutableList<LottoNumber>) {

    fun win(inputLottoNumbers: LottoNumbers): Int {
        return inputLottoNumbers.contains(winningLottoNumbers = winningLottoNumbers)
    }


    override fun toString(): String {
        return "$winningLottoNumbers"
    }
}