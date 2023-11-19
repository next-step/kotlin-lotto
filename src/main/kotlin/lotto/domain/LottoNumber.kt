package lotto.domain

import kotlin.random.Random.Default.nextInt

data class LottoNumber(val number: Int = nextInt(MIN_NUMBER, MAX_NUMBER)) {

    init {
        require(number in MIN_NUMBER..MAX_NUMBER) { "로또 번호는 1~45 사이의 숫자입니다." }
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
    }
}
