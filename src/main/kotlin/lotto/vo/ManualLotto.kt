package lotto.vo

class ManualLotto() {
    var numbers: List<LottoNumber> = listOf()

    fun initLottoNumbers(input: String) {
        LottoNumber.of(input.split(",")).forEach { addLottoNumber(it) }
    }

    private fun addLottoNumber(number: LottoNumber) {
        require(!numbers.contains(number)) { "로또 번호는 중복될 수 없습니다." }
        numbers = numbers.plus(number)
    }
}
