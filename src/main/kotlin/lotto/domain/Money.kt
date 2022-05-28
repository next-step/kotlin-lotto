package lotto.domain

inline class Money(val value: Int) {
    init {
        require(value >= 0) { "0 이상에 금액을 입력해주세요" }
    }
}
