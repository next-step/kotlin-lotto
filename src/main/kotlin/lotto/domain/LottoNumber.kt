package lotto.domain

class LottoNumber(
    val number: Int
) {
    init {
        require(number > 0) { "로또 번호는 양수여야 합니다." }
        require(number in LOTTO_NUMBERS) { "로또 번호는 1~45 사이의 숫자여야 합니다." }
    }

    companion object {
        val LOTTO_NUMBERS: List<Int> = (1..45).toList()
    }
}
