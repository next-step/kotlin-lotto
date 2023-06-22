package lotto.domain

class Tickets(lottoCount: Int, private val numCreator: LottoNumGenerator) {

    val tickets = List(lottoCount) { Lotto(getLottoNumber()) }

    private fun getLottoNumber(): List<Int> {
        val numbers = numCreator.getNums()
        require(numbers.size == 6) { "로또의 숫자 갯수가 부족합니다" }
        require(numbers.all { it in 1..45 }) { "로또의 숫자는 1~45의 숫자만 가능합니다." }
        return numbers
    }
}
