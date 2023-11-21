package lotto.error

sealed class CustomException() : RuntimeException()

class InvalidAmountException(amount: Int) : CustomException() {
    override val message: String = "금액($amount)는 0보다 크거나 같아야 합니다"
}

class InvalidLottoAmountException() : CustomException() {
    override val message: String = "구매 금액이 로또 금액의 배수여야 합니다"
}

class InvalidLottoNumberException(reason: String) : CustomException() {
    override val message: String = "유효하지 않은 로또 번호 : $reason"
}

class InvalidWinningLottoException(reason: String) : CustomException() {
    override val message: String = "유효하지 않은 당첨 로또 : $reason"
}
