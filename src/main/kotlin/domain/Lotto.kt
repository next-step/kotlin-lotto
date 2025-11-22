package domain

class Lotto(val lotto: Set<Int>) {
    init {
        require(lotto.size == 6) { "로또번호는 중복 없는 6자리 숫자여야합니다." }
    }
}
