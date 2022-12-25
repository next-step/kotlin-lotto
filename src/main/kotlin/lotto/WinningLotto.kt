package lotto

class WinningLotto(winningString: String, val bonusNumber: LottoNumber) {

    val winningLottoNumbers: Set<LottoNumber>

    init {
        val stringNumbers = getStringNumbers(winningString)
        winningLottoNumbers = getWinningNumbers(stringNumbers)
    }

    private fun getStringNumbers(winningString: String): List<String> {
        val stringNumbers = winningString.split(",")
        require(stringNumbers.isNotEmpty()) { "input string delimiter" }
        return stringNumbers
    }

    private fun getWinningNumbers(stringNumbers: List<String>): Set<LottoNumber> {
        val lottoNumbers = stringNumbers.map { LottoNumber(it.trim()) }
        return lottoNumbers.toSet()
    }
}
