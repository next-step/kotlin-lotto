package lotto.domain

class Lotto(
    val numbers: List<Int>
) {

    fun countHitNumbers(luckNumberList: List<Int>): Int {
        return numbers.count { number -> luckNumberList.contains(number) }
    }
}
