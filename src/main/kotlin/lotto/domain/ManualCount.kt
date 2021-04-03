package lotto.domain

class ManualCount(val count: Int) {
    constructor(count: String) : this(count.toInt())
}
