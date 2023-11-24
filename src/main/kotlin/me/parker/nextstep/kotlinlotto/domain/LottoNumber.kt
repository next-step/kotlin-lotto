package me.parker.nextstep.kotlinlotto.domain

@JvmInline
value class LottoNumber(val number: Int) {

    init {
        require(number in MIN_NUMBER..MAX_NUMBER) { "로또 번호는 $MIN_NUMBER ~ $MAX_NUMBER 사이만 가능합니다." }
    }

    override fun toString(): String {
        return "$number"
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}
