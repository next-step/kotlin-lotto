package me.parker.nextstep.kotlinlotto.calculator

data class OperandNumber(val value: Int) {
    init {
        require(value >= 0) { "음수는 입력할 수 없습니다." }
    }

    constructor(value: String) : this(value.toInt())
}