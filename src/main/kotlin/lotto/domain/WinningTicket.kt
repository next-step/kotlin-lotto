package lotto.domain

data class WinningTicket(val nums: List<Int>) {
    fun score(lotto: Lotto): Int {
        return lotto.numbers.count { this.nums.contains(it) }
    }
}
