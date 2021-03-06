package lotto

class LottoNumber(number: Int) {
    init {
        require(number in MIN..MAX) { "${number}는 로또 번호가 될 수 없습니다." }
    }

    companion object {
        private const val MIN = 1
        private const val MAX = 45
    }
}
