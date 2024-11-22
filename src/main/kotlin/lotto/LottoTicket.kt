package lotto

class LottoTicket(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            "로또 번호는 총 6개겨야 합니다"
        }
    }
}
