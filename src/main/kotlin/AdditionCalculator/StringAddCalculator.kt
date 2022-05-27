package AdditionCalculator

class StringAddCalculator {
  fun add(tokens: List<String>): Int =
    toIntList(tokens)
      .reduce { total, num ->
        checkPositive(total)
        total + num
      }

  private fun checkPositive(number: Int) {
    if (number < 0) throw RuntimeException("음수는 계산할 수 없습니다.")
  }

  private fun toIntList(list: List<String>) = list.map { it.toInt() }
}
