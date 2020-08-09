package lotto.domain

data class LottoNumber(val value: Int) {

    init {
        require(value in MIN..MAX) { "로또 번호는 $MIN..$MAX 범위 내의 숫자여야 합니다." }
    }

    companion object {
        const val MIN = 1
        const val MAX = 45
    }
}
