package lotto.domain

class LottoJackpotManager {

    fun splitLottoNumber(jackpotNumbers: String, delimiters: String = ", "): List<Int> {
        return jackpotNumbers.split(delimiters).map { it.toInt() }
    }
}
