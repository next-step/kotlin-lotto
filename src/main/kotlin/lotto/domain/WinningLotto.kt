package lotto.domain

class WinningLotto(
    val numbers: List<Int>
) {

    init {
        require(numbers.size == LottoMaker.NUMBER_OF_LOTTO_NUMBERS) { "로또 번호는 6개여야 합니다." }
        require(numbers.all { it > 0 }) { "로또 번호는 양수여야 합니다." }
        require(numbers.all { it in LottoMaker.LOTTO_NUMBERS }) { "로또 번호는 1~45 사이의 숫자여야 합니다." }
    }

    fun checkEqualCount(inputNumbers: List<Int>): Int {
        return inputNumbers.intersect(numbers.toSet()).count()
    }
}
