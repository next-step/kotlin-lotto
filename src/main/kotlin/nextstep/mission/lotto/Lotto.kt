package nextstep.mission.lotto

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "로또 숫자는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "로또 숫자는 중복이 허용되지 않습니다." }
    }
}
