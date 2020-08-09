package lotto.domain

class Amount(total: Int, val manual: Int) {
    val auto = total - manual
}
