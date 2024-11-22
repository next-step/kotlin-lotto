package lotto

class LottoTicket(numbers: List<Int>) {
    val numbers: List<Int> = numbers.sorted()

    init {
        require(numbers.size == 6) {
            "로또 번호는 총 6개겨야 합니다"
        }
    }
}
