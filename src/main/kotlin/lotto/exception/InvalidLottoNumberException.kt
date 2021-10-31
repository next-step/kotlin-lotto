package lotto.exception

class InvalidLottoNumberException : IllegalArgumentException(INVALID_LOTTO_NUMBER_MESSAGE) {
    companion object {
        private const val INVALID_LOTTO_NUMBER_MESSAGE = "잘못된 로또 번호 입니다. 다시 확인해주세요."
    }
}
