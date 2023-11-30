package lotto.vo

class ManualLotto() {
    var numbers: List<LottoNumber> = listOf()

    fun initLottoNumbers(input: String) {
        LottoNumber.of(input.split(",")).forEach { addLottoNumber(it) }
    }

    fun addLottoNumbers(numbers: List<LottoNumber>): ManualLotto {
        numbers.forEach { addLottoNumber(it) }
        return this
    }

    private fun addLottoNumber(number: LottoNumber) {
        require(!numbers.contains(number)) { "로또 번호는 중복될 수 없습니다." }
        numbers = numbers.plus(number)
    }
}
