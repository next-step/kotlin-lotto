package lotto

class Lotto(
    val numbers: List<Int> = generateLottoNumbers(),
    var matchCount: Int = 0
) {

    companion object {
        const val PRICE: Int = 1000
    }

    fun match(target: Lotto) {
        matchCount = numbers.intersect(target.numbers).count()
    }
}
