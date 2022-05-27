package newlotto

import kotlin.math.sign

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.all { it in LottoRange.normalLottoNumberRange }) { "로또 번호는 1 ~ 44 까지 범위만 가질 수 있습니다." }
        require(numbers.toSet().size == LottoRange.normalLottoNumberSize) { "로또 번호는 중복될 수 없습니다." }
    }

    fun match(winningNumbers: List<Int>): Rank {
        var result = 0

        numbers.forEach {
            if(winningNumbers.contains(it)) result += 1
        }

        return Rank.find(result)
    }
}

