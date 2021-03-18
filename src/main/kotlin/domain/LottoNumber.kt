package domain

class LottoNumber(val value: Int) {
    init {
        require(value in MIN..MAX)
    }

    companion object {
        private const val MIN = 1
        private const val MAX = 45
    }
}
