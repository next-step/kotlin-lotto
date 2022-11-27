package lotto

class WinningLottoNumbers(private var winningLottoNumbers: MutableList<LottoNumber>) {

    override fun toString(): String {
        return "$winningLottoNumbers"
    }

    fun win(inputLottoNumbers: LottoNumbers): Int {
        var count = 0
        for (inputLottoNumber in inputLottoNumbers.lottoNumbers) {
            if (winningLottoNumbers.contains(inputLottoNumber)) { // todo depth
                count += 1
            }
        }
        return count
    }
}