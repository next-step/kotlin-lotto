package lotto.domain

object LottoNumberTokenizer {

    fun tokenize(stringLottoNumbers: String): List<Int> {
        return stringLottoNumbers.trim().split(",").map { it.trim().toInt() }
    }
}
