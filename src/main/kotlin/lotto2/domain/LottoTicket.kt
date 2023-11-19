package lotto2.domain

class LottoTicket(val numbers: LottoNumbers) {
    fun isNumberMatched(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }
}
