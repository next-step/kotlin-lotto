package camp.nextstep.lotto.number

data class WinnerNumbers(val winnerNumbers: List<LottoNumber>, val bonusNumber: LottoNumber) {

    init {
        require(winnerNumbers.none { it == bonusNumber }) { "보너스 숫자(${bonusNumber.value}는 당첨 번호($winnerNumbers)와 중복될 수 없습니다." }
    }

    fun count(numbers: List<LottoNumber>): Int {
        return numbers.count { winnerNumbers.contains(it) }
    }
}
