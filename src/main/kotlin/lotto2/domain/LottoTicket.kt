package lotto2.domain

class LottoTicket(val numbers: LottoNumbers) {
    fun isNumberMatched(number: LottoNumber): Boolean {
        return numbers.contains(number)
    }
}
