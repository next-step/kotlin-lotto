package nextstep.mission.lotto

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "로또 숫자는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "로또 숫자는 중복이 허용되지 않습니다." }
        requireRange(numbers.toMutableList())
    }

    private tailrec fun requireRange(numbers: MutableList<Int>) {
        when {
            isInvalidRange(numbers.removeFirst()) -> throw IllegalArgumentException("로또 숫자는 1에서 45사이어야 합니다.")
            else -> requireRange(numbers)
        }
    }

    private fun isInvalidRange(number: Int): Boolean = (number < 1).or(number > 45)
}
