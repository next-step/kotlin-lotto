package lotto.domain

class LottoNumber(val number: Int) {
    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 46

        val CACHED_NUMBER = List(MAX_NUMBER) { num ->
            LottoNumber(num + 1)
        }

        fun valueOf(num: Int): LottoNumber {
            require(num in MIN_NUMBER..MAX_NUMBER) {
                "Invalid LottoNumber: $MIN_NUMBER and ${MAX_NUMBER - 1} 사이의 값이여야 합니다."
            }
            return CACHED_NUMBER[num - 1]
        }
    }

}

