package lotto2.domain

class LottoTicket(val numbers: LottoNumbers) {
    fun isNumberMatched(bonusNumber: LottoNumber): Boolean {
        return numbers.contains(bonusNumber)
    }
}
