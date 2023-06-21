package lotto

class Lotto(
    val numbers: List<LottoNumber>,
    val salePrice: Int = DEFAULT_SALE_PRICE
) {

    init {
        require(numbers.size == MAX_NUMBER_COUNT) { "로또는 6개의 추첨번호를 가져야합니다." }
        require(numbers.distinct().size == MAX_NUMBER_COUNT) { "로또의 모든 추첨번호는 서로 달라야합니다" }
    }
    fun isContainLottoNumber(number: LottoNumber) = this.numbers.contains(number)

    companion object {
        const val MAX_NUMBER_COUNT = 6
        const val DEFAULT_SALE_PRICE = 1_000
    }
}
