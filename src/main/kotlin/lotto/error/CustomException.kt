package lotto.error

sealed class CustomException() : RuntimeException(){
    abstract val errorMessage: String
}

class InvalidAmountException(amount: Int): CustomException() {
    override val errorMessage: String = "금액($amount)는 0보다 크거나 같아야 합니다"
}

class InvalidLottoAmountException(): CustomException() {
    override val errorMessage: String = "구매 금액이 로또 금액의 배수여야 합니다"
}

class InvalidLottoNumberException(reason: String): CustomException() {
    override val errorMessage: String = "유효하지 않은 로또 번호 : $reason"
}

class InvalidWinningLottoException(reason: String): CustomException() {
    override val errorMessage: String = "유효하지 않은 당첨 로또 : $reason"
}
