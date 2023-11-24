package lotto.domain

class Money(val amount : Int) {
    init {
        require(amount > 0){
            "구매금액을 정확히 입력해주세요."
        }
    }
}
