package lotto.domain

object LottoNumberTokenizer {

    fun tokenize(stringLottoNumbers: String): List<Int> {
        if (stringLottoNumbers.isBlank()) return listOf()
        return stringLottoNumbers.trim().split(",").map { it.trim().toInt() }
    }
}
