package lotto.domain

data class LottoWinningNumber(val numbers: Set<Int>) {
    init {
        require(numbers.size == 6) {
            "6자리 로또 당첨 번호를 입력해주세요."
        }
    }
}
