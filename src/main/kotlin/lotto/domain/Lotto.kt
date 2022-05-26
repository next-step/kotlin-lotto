package lotto.domain

class Lotto(generateLists: () -> List<LottoNumber>) {
    var numbers: List<LottoNumber> = listOf()

    init {
        numbers = generateLists()
    }
}
