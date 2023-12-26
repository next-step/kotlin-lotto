package camp.nextstep.edu.step.step2.domain.lotto

import camp.nextstep.edu.step.step2.domain.number.Number

class Lotto(
    val numbers: List<Number>
) {

    fun countMatch(targetLotto: Lotto): Int {
        return numbers.count { targetLotto.numbers.contains(it) }
    }

    fun isDuplicateNumber(anotherNumber: Number): Boolean {
        return numbers.contains(anotherNumber)
    }

    fun countMatchBonus(bonusNumber: Number): Int {
        return numbers.count { it.number == bonusNumber.number }
    }

    fun getNumberElements(): List<Int> {
        return numbers.map { it.number }
    }

    companion object {
        fun ofInputValues(numbers: String): Lotto {
            val numberList = numbers.split(",")
                .map { it.trim() }
                .map { it.toInt() }
            return Lotto(numbers = numberList.map { Number(it) })
        }
    }

}
