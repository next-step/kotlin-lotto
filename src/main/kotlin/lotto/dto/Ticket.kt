package lotto.dto

class Ticket(private val _numbers: List<Int>) {
    init {
        require(_numbers.size == 6)
        require(_numbers.all { it in 1..45 })
        require(_numbers.distinct().size == 6)
        require(_numbers == _numbers.sorted()) { "로또 번호는 오름차순으로 정렬되어야 합니다." }
    }

    fun countSameNumber(ticket: Ticket): Int {
        return _numbers.intersect(ticket._numbers.toSet()).count()
    }
}
