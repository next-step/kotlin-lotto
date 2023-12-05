package camp.nextstep.edu.step.step2.domain.lotto

class Lotto(
    val numbers: List<Number>
) {

    fun countMatch(targetLotto: Lotto): Int {
        return numbers.count { targetLotto.numbers.contains(it) }
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
