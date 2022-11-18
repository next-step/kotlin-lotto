package nextstep.mission.lotto

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "로또 숫자는 6개여야 합니다." }
    }
}
