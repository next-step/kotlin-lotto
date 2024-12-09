package lotto

data class LottoNumber(val number: Int) {
    init {
        require(number in 1..45) { "로또 번호는 1보다 적거나 45보다 클 수 없습니다" }
    }
}