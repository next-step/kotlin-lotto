package lotto.domain

class WinningLotto(
    val numbers: List<Int>
) {

    init {
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다." }
        require(numbers.all { it > 0 }) { "로또 번호는 양수여야 합니다." }
        require(numbers.all { it in 1..45 }) { "로또 번호는 1~45 사이의 숫자여야 합니다." }
    }

    fun checkEqualCount(inputNumbers: List<Int>): Int {
        return inputNumbers.intersect(numbers.toSet()).count()
    }
}
