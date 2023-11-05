package lotto.domain

class Lotto(private val first: Int, private val second: Int, private val third: Int, private val fourth: Int, private val fifth: Int, private val sixth: Int) {

    init {
        val numbers = listOf(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth)

        require(numbers.all { it in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX }) { "로또 번호는 1부터 45까지의 숫자만 가능합니다." }

        require(numbers.distinct().size == numbers.size) { "로또 번호는 중복될 수 없습니다." }
    }

    constructor(vararg numbers: Int) : this(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5])

    fun getLottoNumberList(): List<Int> = listOf(this.first, this.second, this.third, this.fourth, this.fifth, this.sixth)

    companion object {
        const val LOTTO_PRICE: Int = 1000
        const val LOTTO_NUMBER_MIN: Int = 1
        const val LOTTO_NUMBER_MAX: Int = 45
    }
}