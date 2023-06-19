package lotto

class Lotto(
    val numbers: List<LottoNumber>,
    val salePrice: Int
) {

    init {
        require(numbers.size == 6) { "로또는 6개의 추첨번호를 가져야합니다." }
    }
    fun countMatch(winNumbers: List<Int>) = winNumbers.count { numbers.contains(LottoNumber(it)) }
}
