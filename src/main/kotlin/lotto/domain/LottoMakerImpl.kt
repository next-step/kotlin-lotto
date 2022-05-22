package lotto.domain

class LottoMakerImpl : LottoMaker {
    override fun makeLottoNumbers(): List<Int> {
        val range = List(45) { it + 1 }
        val shuffled = range.shuffled()
        return shuffled.subList(0, 6)
    }
}