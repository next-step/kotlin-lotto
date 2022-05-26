package lotto.domain

class Lotto(generateLists: () -> List<LottoNumber>) {
    var numbers: List<LottoNumber> = listOf()

    init {
        numbers = generateLists()
    }

    companion object {
        const val LOTTO_NUMBER_DIVIDE_TEXT = ","
    }
}
