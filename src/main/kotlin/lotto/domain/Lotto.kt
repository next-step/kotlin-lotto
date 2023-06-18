package lotto.domain

class Lotto(numCreator: LottoNumGenerator) {
    val numbers: List<Int>

    init {
        numbers = numCreator.getNums()
    }
}
