package lotto

/**
 * 서로 중복되지 않는 1과 45사이의 숫자 6개를 가지는 로또 클래스 입니다.
 */
data class Lotto(
    val numbers: Set<Int>
) {
    init {
        require(numbers.size == 6) { "lotto number size must be 6" }
        require(numbers.all { it in (1..45) }) { "lotto number must be between 1 and 45" }
    }
}
