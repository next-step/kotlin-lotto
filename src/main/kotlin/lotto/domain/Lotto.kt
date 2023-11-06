package lotto.domain

class Lotto(numbers: List<Int>) {

    private val numbers: List<Int> = numbers.sorted()

    init {
        require(numbers.all { it in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX }) { "로또 번호는 1부터 45까지의 숫자만 가능합니다." }

        require(numbers.distinct().size == numbers.size) { "로또 번호는 중복될 수 없습니다." }
    }

    fun getLottoNumberList(): List<Int> = this.numbers

    fun getMatchCount(lotto: Lotto): Int = this.numbers.intersect(lotto.getLottoNumberList().toSet()).size

    companion object {
        const val LOTTO_PRICE: Int = 1000
        const val LOTTO_NUMBER_MIN: Int = 1
        const val LOTTO_NUMBER_MAX: Int = 45
    }
}
