package lotto.domain

@JvmInline
value class Money(val value: Int) {
    init {
        require(value >= 0) { "$value 금액은 설정할수 없습니다. 0 이상에 금액을 입력해주세요" }
    }
}
