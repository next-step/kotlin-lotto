package lotto.domain

class LottoNumber(val number: Int) {

    init {
        require(number in MIN_NUMBER..MAX_NUMBER) {
            "로또 번호는 1 이상 45 이하여야 합니다."
        }
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }

}