package lotto

class LottoTicket(numbers: List<Int>) {
    val numbers: List<Int> = numbers.sorted()

    init {
        require(numbers.size == 6) {
            "로또 번호는 총 6개겨야 합니다"
        }
        require(numbers.all { (1..45).contains(it) }) {
            "로또 번호는 1에서 45까지만 허용합니다"
        }
    }
}
