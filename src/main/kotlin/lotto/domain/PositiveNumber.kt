package lotto.domain

data class PositiveNumber(val value: Int) {

    init {
        check(value > 0) { "자연수가 아닙니다. value: $value" }
    }
}
