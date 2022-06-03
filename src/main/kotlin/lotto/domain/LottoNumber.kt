package lotto.domain

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in MIN_NUMBER..MAX_NUMBER) { "로또 번호는 $MIN_NUMBER~$MAX_NUMBER 범위만 가진다." }
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}
